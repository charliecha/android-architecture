package com.example.coroutinescope.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class User

class MainViewModel : ViewModel() {
    init {
        viewModelScope.launch {
            // coroutine that be conceled when ViewModel is cleared
            Log.i("CoroutineScope","viewModelScope")
        }
    }

    val user : LiveData<User> = liveData<User> {
        val data = loadUser()
        emit(data)
    }

    suspend private fun loadUser() : User {
        return User()
    }
}