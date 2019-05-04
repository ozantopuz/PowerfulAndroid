package com.ozantopuz.powerfulAndroid.scene.dashboard.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ozantopuz.powerfulAndroid.core.extensions.addTo
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseViewModel
import com.ozantopuz.powerfulAndroid.core.utils.Constants.API_URL
import com.ozantopuz.powerfulAndroid.core.utils.Constants.LANGUAGE
import com.ozantopuz.powerfulAndroid.core.utils.Constants.PAGE
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import com.ozantopuz.powerfulAndroid.data.repository.MovieRepository
import javax.inject.Inject


class DashboardViewModel @Inject constructor(private val repository : MovieRepository): BaseViewModel() {

    var isLoading = MutableLiveData<Boolean>()
    var movies = MutableLiveData<List<Movie>>()

    override fun onViewAttached() {
        getMovies()
    }

    private fun getMovies(){
        repository.getMovies(LANGUAGE, PAGE)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .doOnSubscribe { isLoading.value = true }
            .subscribe {
                isLoading.value = false
                movies.value = it
            }.addTo(disposeBag)
    }
}