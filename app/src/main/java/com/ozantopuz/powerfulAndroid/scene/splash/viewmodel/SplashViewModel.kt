package com.ozantopuz.powerfulAndroid.scene.splash.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ozantopuz.powerfulAndroid.core.extensions.addTo
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseViewModel
import com.ozantopuz.powerfulAndroid.core.navigator.Navigator.open
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import com.ozantopuz.powerfulAndroid.scene.dashboard.view.DashboardActivity
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject



class SplashViewModel @Inject constructor(): BaseViewModel() {

    var delay = MutableLiveData<Unit>()

    override fun onViewAttached() {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.main())
            .subscribe { delay.value = Unit  }
            .addTo(disposeBag)
    }
}