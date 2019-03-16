package com.ozantopuz.powerfulAndroid.scene.dashboard.view

import com.ozantopuz.powerfulAndroid.R
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseActivity
import com.ozantopuz.powerfulAndroid.core.mvvm.with
import com.ozantopuz.powerfulAndroid.databinding.ActivityDashboardBinding
import com.ozantopuz.powerfulAndroid.scene.dashboard.viewmodel.DashboardViewModel

class DashboardActivity : BaseActivity<ActivityDashboardBinding, DashboardViewModel>() {

    override fun layoutId() = R.layout.activity_dashboard

    override fun instantiateViewModel(): DashboardViewModel = with(viewModelFactory)

    override fun attachView() = viewModel.attachView(lifecycle)

    override fun setupView() {
        /*viewModel.movies.observe(this, Observer {
                Toast.makeText(this, it[0].title, Toast.LENGTH_SHORT).show()
        })*/
    }
}
