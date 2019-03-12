package com.ozantopuz.powerfulAndroid.core.mvvm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<B: ViewDataBinding, T : BaseViewModel> : DaggerFragment() {

    @LayoutRes
    abstract fun layoutId(): Int

    abstract fun instantiateViewModel(): T

    abstract fun attachView()

    abstract fun setupView()

    abstract fun bindViewModel()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: T
        internal set

    lateinit var binding: B


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        viewModel = instantiateViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)


        attachView()
        lifecycle.addObserver(viewModel)

        setupView()

        bindViewModel()

        return binding.root
    }
}