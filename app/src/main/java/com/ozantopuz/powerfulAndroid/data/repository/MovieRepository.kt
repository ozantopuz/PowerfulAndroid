package com.ozantopuz.powerfulAndroid.data.repository

import com.ozantopuz.powerfulAndroid.data.entity.Movie
import io.reactivex.Observable

interface MovieRepository {

    fun getMovies(language : Observable<String>, page : Observable<Int>): Observable<List<Movie>>

    fun getMovie(id : Int?): Observable<Movie>
}