package com.adrian.marvelsearch.main.usecase

import com.adrian.marvelsearch.main.datasource.HeroesDataSource
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHeroes @Inject constructor(private val heroesRepository: HeroesDataSource) {

    fun execute(): Single<List<String>> = heroesRepository.getHeroes()
}