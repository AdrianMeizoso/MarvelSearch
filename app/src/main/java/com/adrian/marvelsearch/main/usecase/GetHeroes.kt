package com.adrian.marvelsearch.main.usecase

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHeroes @Inject constructor() {

    fun execute(): Single<ArrayList<String>> = Single.just(arrayListOf("Mandarina", "Palos", "Retrueque"))
}