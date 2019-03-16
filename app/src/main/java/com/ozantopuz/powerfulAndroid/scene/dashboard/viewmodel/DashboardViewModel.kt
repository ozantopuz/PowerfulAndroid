package com.ozantopuz.powerfulAndroid.scene.dashboard.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ozantopuz.powerfulAndroid.core.extensions.addTo
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseViewModel
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import com.ozantopuz.powerfulAndroid.data.usecase.MovieUseCase
import javax.inject.Inject



class DashboardViewModel @Inject constructor(private val useCase : MovieUseCase): BaseViewModel() {

    override fun onViewAttached() {

    }

    var error = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()
    var movies = MutableLiveData<List<Movie>>()

    private fun getTopRated(){
        useCase.getTopRated("d4f51d41f184b6d5b7ebfeff479bd5fc","en",1)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .doOnSubscribe { isLoading.value = true }
            .doOnTerminate { isLoading.value = false }
            .subscribe(
                { movies.value = it.results },
                { error.value = it.localizedMessage }
            ).addTo(disposeBag)
    }
}