package com.adrian.marvelsearch.main

import com.adrian.marvelsearch.main.datasource.HeroesApiDataSource
import com.adrian.marvelsearch.main.datasource.HeroesDataSource
import io.reactivex.Single

class HeroesRepository(private val heroesApiDataSource: HeroesApiDataSource) : HeroesDataSource {

    override fun getHeroes(): Single<List<String>> = Single.just(arrayListOf("Mandarina", "Palos", "Retrueque"))
}