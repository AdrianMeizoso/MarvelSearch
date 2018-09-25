package com.adrian.marvelsearch.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val text: MutableLiveData<String> = MutableLiveData()

    fun init() :MutableLiveData<String>{
        text.value = "Cojonudo!"
        return text
    }
}