package com.ozantopuz.powerfulAndroid.scene.dashboard.view

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.jakewharton.rxbinding2.view.RxView
import com.minimize.android.rxrecycleradapter.RxDataSource
import com.ozantopuz.powerfulAndroid.R
import com.ozantopuz.powerfulAndroid.core.extensions.addTo
import com.ozantopuz.powerfulAndroid.core.extensions.ignoreNull
import com.ozantopuz.powerfulAndroid.core.extensions.toast
import com.ozantopuz.powerfulAndroid.core.helper.ProgressBarHelper.hideLoading
import com.ozantopuz.powerfulAndroid.core.helper.ProgressBarHelper.showLoading
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseActivity
import com.ozantopuz.powerfulAndroid.core.mvvm.with
import com.ozantopuz.powerfulAndroid.core.navigator.Navigator.openWithId
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import com.ozantopuz.powerfulAndroid.databinding.ActivityDashboardBinding
import com.ozantopuz.powerfulAndroid.databinding.LayoutItemMovieBinding
import com.ozantopuz.powerfulAndroid.scene.dashboard.viewmodel.DashboardViewModel
import com.ozantopuz.powerfulAndroid.scene.movie.view.MovieActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.layout_item_movie.view.*

class DashboardActivity : BaseActivity<ActivityDashboardBinding, DashboardViewModel>() {

    private val rxDataSource = RxDataSource<LayoutItemMovieBinding, Movie>(R.layout.layout_item_movie, listOf())

    override fun layoutId() = R.layout.activity_dashboard

    override fun instantiateViewModel(): DashboardViewModel = with(viewModelFactory)

    override fun attachView() = viewModel.attachView(lifecycle)

    override fun setupView() {
        setRecyclerView()
    }

    override fun bindViewModel() {
        viewModel.isLoading.observe(this, Observer { if (it) showLoading() else hideLoading() })
        viewModel.movies.observe(this, Observer { updateRecyclerView(it) })
    }

    private fun updateRecyclerView(movies : List<Movie>) {
        runOnUiThread { rxDataSource.updateDataSet(movies).updateAdapter() }
    }

    private fun setRecyclerView(){
        movieRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@DashboardActivity, 2)
        }

        rxDataSource
            .asObservable()
            .subscribe {
                val binding = it.viewDataBinding ?: return@subscribe
                it.item.let{ i ->
                    if (i != null) {
                        binding.image = i.posterPath.ignoreNull()

                        RxView.clicks(it.itemView.cardView).subscribe { openWithId<MovieActivity>(i.id) }.addTo(disposeBag)
                        RxView.longClicks(it.itemView.cardView).subscribe { toast(i.title) }.addTo(disposeBag)
                    }
                }
            }.addTo(disposeBag)

        rxDataSource.bindRecyclerView(movieRecyclerView)
    }
}
