package com.ozantopuz.powerfulAndroid.core.dagger.module

import com.ozantopuz.powerfulAndroid.core.dagger.scope.ActivityScoped
import com.ozantopuz.powerfulAndroid.scene.dashboard.module.DashboardModule
import com.ozantopuz.powerfulAndroid.scene.dashboard.view.DashboardActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [DashboardModule::class])
    internal abstract fun dashboardActivity(): DashboardActivity

}