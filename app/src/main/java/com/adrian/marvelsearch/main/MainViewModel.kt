package com.adrian.marvelsearch.main

import androidx.lifecycle.MutableLiveData
import com.adrian.marvelsearch.common.BaseViewModel
import com.adrian.marvelsearch.main.usecase.GetHeroes

class MainViewModel(private var getHeroes: GetHeroes) : BaseViewModel() {

    val text: MutableLiveData<String> = MutableLiveData()

    fun getTextData(): MutableLiveData<String> {
        disposables.add(getHeroes.execute().subscribe { data ->
            text.value = data[1]
        })
        return text
    }
}