package com.testdemo.cleanarchitectureapp.ui.userlidt.datalayer

import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.AllData

interface UserRepository {
    suspend fun getUsers(): AllData
}