package com.example.livedata.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel : ViewModel() {
    private val counter1: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(1)
    }

    val counter: LiveData<String> = counter1.map { "current counter is ${it ?: 0}" }

    fun add() {
        val old: Int = counter1.value ?: 0
        counter1.value = 1 + old
    }
}