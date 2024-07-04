package com.testdemo.cleanarchitectureapp

import android.os.Bundle
import android.view.animation.AnimationUtils
import com.testdemo.cleanarchitectureapp.base.BaseActivity
import com.testdemo.cleanarchitectureapp.databinding.ActivityMainBinding
import com.testdemo.cleanarchitectureapp.ui.userlidt.presentation.UserListActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {
    private val TAG="MainActivity"
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getLog(TAG,"Splash Screen")
        val fadeInAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.ivLogo.startAnimation(fadeInAnimation)
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            switchActivity(UserListActivity::class.java)
            finish()
        }
    }

}