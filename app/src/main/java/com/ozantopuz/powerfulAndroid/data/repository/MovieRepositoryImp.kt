package com.ozantopuz.powerfulAndroid.data.repository

import com.ozantopuz.powerfulAndroid.data.entity.Movie
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(): MovieRepository {

    override fun saveMovies(movies: List<Movie>) {

    }

    override fun getMovies(): List<Movie> {
        return listOf()
    }
}