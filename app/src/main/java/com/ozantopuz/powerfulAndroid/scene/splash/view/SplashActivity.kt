package com.ozantopuz.powerfulAndroid.scene.splash.view

import androidx.lifecycle.Observer
import com.ozantopuz.powerfulAndroid.R
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseActivity
import com.ozantopuz.powerfulAndroid.core.mvvm.with
import com.ozantopuz.powerfulAndroid.core.navigator.Navigator.clearAndOpen
import com.ozantopuz.powerfulAndroid.databinding.ActivitySplashBinding
import com.ozantopuz.powerfulAndroid.scene.dashboard.view.DashboardActivity
import com.ozantopuz.powerfulAndroid.scene.splash.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {


    override fun layoutId() = R.layout.activity_splash

    override fun instantiateViewModel(): SplashViewModel = with(viewModelFactory)

    override fun attachView() = viewModel.attachView(lifecycle)

    override fun setupView() {
        viewModel.delay.observe(this, Observer { clearAndOpen<DashboardActivity>() })
    }

    override fun bindViewmodel() {

    }
}
