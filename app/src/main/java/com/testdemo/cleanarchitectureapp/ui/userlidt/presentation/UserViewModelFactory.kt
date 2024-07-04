package com.testdemo.cleanarchitectureapp.ui.userlidt.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.GetUserUseCase

class UserViewModelFactory(private val getUserUseCase: GetUserUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(getUserUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}