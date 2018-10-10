package com.adrian.marvelsearch.main.domain

import androidx.paging.ItemKeyedDataSource
import androidx.paging.PageKeyedDataSource
import androidx.paging.PositionalDataSource
import com.adrian.marvelsearch.main.usecase.GetHeroes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HeroesPagingDataSource(
        private val getHeroes: GetHeroes,
        private val compositeDisposable: CompositeDisposable) : PageKeyedDataSource<Int,MarvelHero>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MarvelHero>) {
        compositeDisposable.add(getHeroes.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { marvelHeroes: List<MarvelHero>?, _: Throwable? ->
                    marvelHeroes?.let { callback.onResult(it, 0, 20) }
                })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MarvelHero>) {
        getHeroes.offset = params.key
        compositeDisposable.add(getHeroes.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { marvelHeroes: List<MarvelHero>?, _: Throwable? ->
                    marvelHeroes?.let { callback.onResult(it, params.key + 20) }
                })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MarvelHero>) {}
}