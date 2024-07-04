package com.testdemo.cleanarchitectureapp.ui.userlidt.datalayer

import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.User
import com.testdemo.cleanarchitectureapp.networks.WebInterface
import com.testdemo.cleanarchitectureapp.ui.userlidt.datalayer.UserRepository
import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.AllData

class UserRepositoryImpl(private val webInterface: WebInterface) : UserRepository {
    override suspend fun getUsers(): AllData {
        return webInterface.getUsers()
    }
}