package com.testdemo.cleanarchitectureapp.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.testdemo.cleanarchitectureapp.ui.userlidt.presentation.UserListActivity

open class BaseActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    fun getLog(tag:String,message: String) {
        Log.e(tag,"Print: $message")
    }
    fun switchActivity(desiClass: Class<UserListActivity>) {
        startActivity(Intent(this, desiClass))
    }




}