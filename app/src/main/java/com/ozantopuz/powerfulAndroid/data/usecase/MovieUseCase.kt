package com.ozantopuz.powerfulAndroid.data.usecase

import com.ozantopuz.powerfulAndroid.core.base.BaseEntity
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import io.reactivex.Flowable

interface MovieUseCase {

    fun getTopRated(apiKey : String, language : String, page : Int): Flowable<BaseEntity<Movie>>
}