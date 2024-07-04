package com.testdemo.cleanarchitectureapp.ui.userlidt.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.AllData
import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.GetUserUseCase
import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.User
import kotlinx.coroutines.launch

class UserViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel(){
    private val _users = MutableLiveData<AllData>()
    val users: LiveData<AllData> get() = _users

    init {
        viewModelScope.launch {
            try {
                _users.value = getUserUseCase()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}