package com.test.networkandjson.movie

import com.google.gson.annotations.SerializedName

/**
 * Created by nampham on 5/10/21.
 */
data class MovieResp (
    val dates: Dates? = null,
    val page: Long? = null,
    var results: List<Movie>? = null,
    val totalPages: Long? = null,
    val totalResults: Long? = null
)

data class Dates (
    val maximum: String? = null,
    val minimum: String? = null
)
