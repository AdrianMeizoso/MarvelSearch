package com.adrian.marvelsearch.main.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarvelResponse(
        val code: Int,
        val status: String,
        @Json(name = "data") val marvelData: MarvelData)

@JsonClass(generateAdapter = true)
data class MarvelData(
        val offset: Int,
        val limit: Int,
        @Json(name = "results") val marvelHeroes: List<MarvelHero>)

@JsonClass(generateAdapter = true)
data class MarvelHero(
        val id: Int,
        val name: String,
        val description: String,
        val thumbnail: MarvelThumbnail)

@JsonClass(generateAdapter = true)
data class MarvelThumbnail(
        val path: String,
        val extension: String)