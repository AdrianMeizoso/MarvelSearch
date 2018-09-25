package com.adrian.marvelsearch.common

import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    //var disposables: CompositeDisposables

    override fun onCleared() {
        super.onCleared()
        //disposables.clear()
    }
}