package com.adrian.marvelsearch.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.adrian.marvelsearch.common.BaseViewModel
import com.adrian.marvelsearch.main.domain.HeroesPagingDataSourceFactory
import com.adrian.marvelsearch.main.domain.MarvelHero
import com.adrian.marvelsearch.main.domain.MarvelResponse
import com.adrian.marvelsearch.main.usecase.GetHeroes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(getHeroes: GetHeroes) : BaseViewModel() {

    val heroesList: LiveData<PagedList<MarvelHero>>
    var heroesListHash: HashMap<Int, MarvelHero> = HashMap()

    private val pagedListConfig by lazy {
        PagedList.Config.Builder().setEnablePlaceholders(false)
                .setInitialLoadSizeHint(20)
                .setPageSize(20)
                .setPrefetchDistance(40)
                .build()
    }

    init {
        val sourceFactory = HeroesPagingDataSourceFactory(disposables, getHeroes)
        heroesList = LivePagedListBuilder(sourceFactory, pagedListConfig).build()
    }

    fun getHeroById(heroId: Int): MarvelHero? = heroesListHash[heroId]
}