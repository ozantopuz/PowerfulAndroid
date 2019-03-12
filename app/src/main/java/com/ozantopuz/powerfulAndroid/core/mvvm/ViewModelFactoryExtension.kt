package com.ozantopuz.powerfulAndroid.core.mvvm

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.with(factory: ViewModelProvider.Factory): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    return vm
}

inline fun <reified T : ViewModel> AppCompatActivity.with(factory: ViewModelProvider.Factory): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    return vm
}