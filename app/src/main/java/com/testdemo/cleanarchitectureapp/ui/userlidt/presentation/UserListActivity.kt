package com.testdemo.cleanarchitectureapp.ui.userlidt.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.testdemo.cleanarchitectureapp.R
import com.testdemo.cleanarchitectureapp.adapters.UserAdapter
import com.testdemo.cleanarchitectureapp.base.BaseActivity
import com.testdemo.cleanarchitectureapp.databinding.ActivityUserListBinding
import com.testdemo.cleanarchitectureapp.networks.RetrofitInstance
import com.testdemo.cleanarchitectureapp.ui.userlidt.datalayer.UserRepositoryImpl
import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.GetUserUseCase


class UserListActivity : BaseActivity() {
    private val TAG="UserListActivity"
    private lateinit var binding:ActivityUserListBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        val userRepository = UserRepositoryImpl(RetrofitInstance.apiService)
        val getUsersUseCase = GetUserUseCase(userRepository)
        val factory = UserViewModelFactory(getUsersUseCase)
        userViewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)
        binding.viewModel = userViewModel
        binding.lifecycleOwner = this



        userAdapter = UserAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@UserListActivity)
            adapter = userAdapter
        }

        // Observe LiveData
        userViewModel.users.observe(this, Observer { user ->
            userAdapter.submitList(user.data)
        })
    }


}