package com.ozantopuz.powerfulAndroid.core.dagger.module

import android.content.Context
import com.ozantopuz.powerfulAndroid.app.App
import com.ozantopuz.powerfulAndroid.core.rx.AppSchedulers
import com.ozantopuz.powerfulAndroid.core.rx.SchedulerProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(androidApplication: App): Context

    @Binds
    abstract fun bindSchedulers(scheduler: AppSchedulers): SchedulerProvider
}