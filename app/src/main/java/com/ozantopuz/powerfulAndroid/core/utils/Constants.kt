package com.ozantopuz.powerfulAndroid.core.utils

import io.reactivex.Observable

object Constants {

    const val DATABASE_NAME = "movie_db"
    const val API_URL  = "d4f51d41f184b6d5b7ebfeff479bd5fc"
    val LANGUAGE : Observable<String> = Observable.just("en")
    val PAGE : Observable<Int> = Observable.just(1)
}