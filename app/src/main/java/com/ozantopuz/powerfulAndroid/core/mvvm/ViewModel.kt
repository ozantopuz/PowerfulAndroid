package com.ozantopuz.powerfulAndroid.core.mvvm

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

interface ViewModel: LifecycleObserver {
    fun attachView(lifecycle: Lifecycle)
}