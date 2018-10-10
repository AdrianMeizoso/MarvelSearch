package com.adrian.marvelsearch.main.usecase

import com.adrian.marvelsearch.main.datasource.HeroesDataSource
import com.adrian.marvelsearch.main.domain.MarvelHero
import com.adrian.marvelsearch.main.domain.MarvelResponse
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHeroes @Inject constructor(private val heroesRepository: HeroesDataSource) {

    var offset: Int = 0

    fun execute(): Single<List<MarvelHero>> {
        return heroesRepository
                .getHeroes(offset)
                .flatMap { Single.just(it.marvelData.marvelHeroes) }
                .doFinally { offset = 0 }
    }
}