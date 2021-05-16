package com.test.networkandjson.rest

import com.test.networkandjson.movie.MovieResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by nampham on 5/10/21.
 */
interface MovieDBService {

    @GET("movie/now_playing")
    suspend fun listNowPlayMovies(
        @Query("language") language: String, @Query("page") page: Int,
    ): MovieResp


    @GET("movie/top_rated")
    suspend fun listTopRatedMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieResp

}
