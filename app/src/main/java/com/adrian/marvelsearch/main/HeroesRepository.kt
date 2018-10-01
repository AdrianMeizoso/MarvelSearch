package com.adrian.marvelsearch.main

import com.adrian.marvelsearch.common.injection.md5
import com.adrian.marvelsearch.main.datasource.HeroesApiDataSource
import com.adrian.marvelsearch.main.datasource.HeroesDataSource
import com.adrian.marvelsearch.main.domain.MarvelResponse
import io.reactivex.Single

class HeroesRepository(private val heroesApiDataSource: HeroesApiDataSource) : HeroesDataSource {

    companion object {
        const val APIKEYPUBLIC = "cd4ea2ed65ba80284996b3663c7f2b97"
        const val APIKEYPRIVATE = "bc381ea87c7c0f18495430bb551ef8498220dd97"
    }

    override fun getHeroes(): Single<MarvelResponse> {
        val millis = System.currentTimeMillis()
        val hash = "$millis$APIKEYPRIVATE$APIKEYPUBLIC".md5()
        return heroesApiDataSource.getHeroes( millis.toString(), APIKEYPUBLIC, hash)
    }
}