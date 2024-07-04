package com.testdemo.cleanarchitectureapp.networks

import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.AllData
import com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer.User
import retrofit2.http.GET

interface WebInterface {
    @GET("users?page=2")
    suspend fun getUsers(): AllData

}