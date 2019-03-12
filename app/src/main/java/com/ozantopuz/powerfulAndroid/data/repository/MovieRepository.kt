package com.ozantopuz.powerfulAndroid.data.repository

import com.ozantopuz.powerfulAndroid.data.entity.Movie

interface MovieRepository {

    fun saveMovies(movies: List<Movie>)

    fun getMovies() : List<Movie>
}