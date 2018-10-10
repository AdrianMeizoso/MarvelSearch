package com.adrian.marvelsearch.main.domain

import androidx.paging.PositionalDataSource
import com.adrian.marvelsearch.main.usecase.GetHeroes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HeroesPagingDataSource(
        private val getHeroes: GetHeroes,
        private val compositeDisposable: CompositeDisposable) : PositionalDataSource<MarvelHero>() {

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<MarvelHero>) {
        compositeDisposable.add(getHeroes.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { marvelHeroes: List<MarvelHero>?, _: Throwable? ->
                    marvelHeroes?.let { callback.onResult(it, params.requestedStartPosition, params.requestedLoadSize) }
                })
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MarvelHero>) {
        getHeroes.offset = params.startPosition
        compositeDisposable.add(getHeroes.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { marvelHeroes: List<MarvelHero>?, _: Throwable? ->
                    marvelHeroes?.let { callback.onResult(it) }
                })
    }
}