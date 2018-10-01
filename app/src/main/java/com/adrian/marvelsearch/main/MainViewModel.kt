package com.adrian.marvelsearch.main

import androidx.lifecycle.MutableLiveData
import com.adrian.marvelsearch.common.BaseViewModel
import com.adrian.marvelsearch.main.domain.MarvelResponse
import com.adrian.marvelsearch.main.usecase.GetHeroes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private var getHeroes: GetHeroes) : BaseViewModel() {

    val text: MutableLiveData<String> = MutableLiveData()

    fun getTextData() {
        disposables.add(getHeroes.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data: MarvelResponse?, error: Throwable? ->
                    text.value =
                            if (data != null) data.status
                            else error!!.message
                })
    }
}