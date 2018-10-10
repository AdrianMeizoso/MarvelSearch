package com.adrian.marvelsearch.main.domain

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.adrian.marvelsearch.main.usecase.GetHeroes
import io.reactivex.disposables.CompositeDisposable

class HeroesPagingDataSourceFactory(private val compositeDisposable: CompositeDisposable,
                                    private val getHeroes: GetHeroes)
    : DataSource.Factory<Int, MarvelHero>() {

    private val usersDataSourceLiveData = MutableLiveData<HeroesPagingDataSource>()

    override fun create(): DataSource<Int, MarvelHero> {
        val heroesPagingDataSource = HeroesPagingDataSource(getHeroes, compositeDisposable)
        usersDataSourceLiveData.postValue(heroesPagingDataSource)
        return heroesPagingDataSource
    }
}