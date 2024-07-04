package com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer

import com.testdemo.cleanarchitectureapp.ui.userlidt.datalayer.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(): AllData {
        return userRepository.getUsers()
    }
}