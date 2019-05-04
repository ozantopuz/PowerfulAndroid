package com.ozantopuz.powerfulAndroid.data.repository

import com.ozantopuz.powerfulAndroid.core.extensions.ignoreNull
import com.ozantopuz.powerfulAndroid.core.utils.Constants.API_URL
import com.ozantopuz.powerfulAndroid.data.dao.MovieDao
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import com.ozantopuz.powerfulAndroid.data.service.MovieApi
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val dao : MovieDao, private val api: MovieApi): MovieRepository {

    data class Queries(val language: String, val page: Int)

    override fun getMovies(language: Observable<String>, page: Observable<Int>): Observable<List<Movie>> {

        val queries = Observables.combineLatest(
            language,
            page)
        { first, second -> return@combineLatest Queries(first, second) }

        return queries
            .flatMap { getMoviesFromApi(it.language, it.page) }
            .onErrorResumeNext(getMoviesFromDb())
    }

    override fun getMovie(id: Int?): Observable<Movie> = dao.getMovie(id.ignoreNull()).toObservable()


    private fun getMoviesFromApi(language: String, page: Int): Observable<List<Movie>> {
        return api.getTopRated(API_URL, language, page)
            .map {
                it.results.ignoreNull() }
            .doOnNext {
                dao.insertAll(it) }
            .toObservable()
    }

    private fun getMoviesFromDb(): Observable<List<Movie>> {
        return dao.getAll().toObservable()
    }
}