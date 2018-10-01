package com.adrian.marvelsearch.main.datasource

import com.adrian.marvelsearch.main.domain.MarvelResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroesApiDataSource {

    @GET("characters")
    fun getHeroes(@Query("ts") timestamp: String,
                  @Query("apikey") apiKey: String,
                  @Query("hash") hash: String)
            : Single<MarvelResponse>
}