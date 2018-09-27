package com.adrian.marvelsearch.main.datasource

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface HeroesApiDataSource {

    @Headers("Content-Type: application/json")
    @GET("/{example}/example/example")
    fun getHeroes(): Single<List<String>>

}