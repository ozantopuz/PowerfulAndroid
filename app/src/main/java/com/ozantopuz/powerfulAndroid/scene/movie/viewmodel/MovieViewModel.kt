package com.ozantopuz.powerfulAndroid.scene.movie.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ozantopuz.powerfulAndroid.core.extensions.addTo
import com.ozantopuz.powerfulAndroid.core.extensions.ignoreNull
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseViewModel
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import com.ozantopuz.powerfulAndroid.data.repository.MovieRepository
import javax.inject.Inject


class MovieViewModel @Inject constructor(private val repository : MovieRepository): BaseViewModel() {

    var id = MutableLiveData<Int>()
    var movie = MutableLiveData<Movie>()

    override fun onViewAttached() {
    }

    fun getMovie(){
        repository.getMovie(id.value)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .subscribe { movie.value = it }
            .addTo(disposeBag)
    }

    fun getImage() : MutableLiveData<String> {
        val liveData = MutableLiveData<String>()
        liveData.value = movie.value?.backdropPath.ignoreNull()
       return liveData
    }

    fun getVoteAverage() : MutableLiveData<String> {
        val liveData = MutableLiveData<String>()
        liveData.value = movie.value?.voteAverage.toString()
        return liveData
    }

    fun getReleaseDate() : MutableLiveData<String> {
        val liveData = MutableLiveData<String>()
        liveData.value = movie.value?.releaseDate.ignoreNull()
        return liveData
    }

    fun getPopularity() : MutableLiveData<String> {
        val liveData = MutableLiveData<String>()
        liveData.value = movie.value?.popularity.toString()
        return liveData
    }

    fun getVoteCount() : MutableLiveData<String> {
        val liveData = MutableLiveData<String>()
        liveData.value = movie.value?.voteCount.toString()
        return liveData
    }

    fun getOverview() : MutableLiveData<String> {
        val liveData = MutableLiveData<String>()
        liveData.value = movie.value?.overview.toString()
        return liveData
    }
}