package com.adrian.marvelsearch.main.datasource

import com.adrian.marvelsearch.main.domain.MarvelResponse
import io.reactivex.Single

interface HeroesDataSource {

    fun getHeroes(offset: Int): Single<MarvelResponse>

}