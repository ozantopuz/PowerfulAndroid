package com.ozantopuz.powerfulAndroid.core.dagger.module

import com.ozantopuz.powerfulAndroid.core.dagger.scope.ActivityScoped
import com.ozantopuz.powerfulAndroid.scene.dashboard.module.DashboardModule
import com.ozantopuz.powerfulAndroid.scene.dashboard.view.DashboardActivity
import com.ozantopuz.powerfulAndroid.scene.movie.module.MovieModule
import com.ozantopuz.powerfulAndroid.scene.movie.view.MovieActivity
import com.ozantopuz.powerfulAndroid.scene.splash.module.SplashModule
import com.ozantopuz.powerfulAndroid.scene.splash.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SplashModule::class])
    internal abstract fun splashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [DashboardModule::class])
    internal abstract fun dashboardActivity(): DashboardActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MovieModule::class])
    internal abstract fun movieActivity(): MovieActivity

}