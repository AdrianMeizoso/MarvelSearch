package com.adrian.marvelsearch.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adrian.marvelsearch.main.usecase.GetHeroes
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private var getHeroes: GetHeroes)  : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getHeroes) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}