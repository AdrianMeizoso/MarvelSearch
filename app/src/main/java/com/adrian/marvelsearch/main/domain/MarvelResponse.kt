package com.adrian.marvelsearch.main.domain

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarvelResponse(
        val code: Int,
        val status: String)