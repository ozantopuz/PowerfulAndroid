package com.ozantopuz.powerfulAndroid.scene.movie.view

import android.os.Handler
import androidx.lifecycle.Observer
import com.ozantopuz.powerfulAndroid.R
import com.ozantopuz.powerfulAndroid.core.mvvm.BaseActivity
import com.ozantopuz.powerfulAndroid.core.mvvm.with
import com.ozantopuz.powerfulAndroid.databinding.ActivityMovieStartBinding
import com.ozantopuz.powerfulAndroid.scene.movie.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_movie_start.*


class MovieActivity : BaseActivity<ActivityMovieStartBinding, MovieViewModel>() {

    var id : Int? = null

    override fun layoutId() = R.layout.activity_movie_start

    override fun instantiateViewModel(): MovieViewModel = with(viewModelFactory)

    override fun attachView() = viewModel.attachView(lifecycle)

    override fun setupView() {
        id = intent.getIntExtra("id", 0)
    }

    override fun bindViewModel() {
        viewModel.id.value = id
        viewModel.getMovie()

        viewModel.movie.observe(this, Observer {
            supportActionBar?.title = it.title

            binding.viewModel = viewModel
            binding.lifecycleOwner = this@MovieActivity

            Handler().postDelayed({ motionLayout?.transitionToEnd() }, 500)
        })
    }
}
