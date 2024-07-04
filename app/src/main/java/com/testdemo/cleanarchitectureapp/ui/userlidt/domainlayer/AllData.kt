package com.testdemo.cleanarchitectureapp.ui.userlidt.domainlayer

data class AllData (
    val page: Long,
    val per_page: Long,
    val total: Long,
    val total_pages: Long,
    val data: List<User>,
    val support: Support
)
data class User(
    val id: Long,
    val email: String,
    val firstName: String,
    val last_name: String,
    val avatar: String
)
data class Support (
    val url: String,
    val text: String
)