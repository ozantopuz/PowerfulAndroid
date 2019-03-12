package com.ozantopuz.powerfulAndroid.data.service

import com.ozantopuz.powerfulAndroid.core.base.BaseEntity
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Flowable<BaseEntity<Movie>>
}