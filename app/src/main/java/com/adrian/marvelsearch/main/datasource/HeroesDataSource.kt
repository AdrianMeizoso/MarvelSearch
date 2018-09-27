package com.adrian.marvelsearch.main.datasource

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface HeroesDataSource {

    fun getHeroes(): Single<List<String>>

}