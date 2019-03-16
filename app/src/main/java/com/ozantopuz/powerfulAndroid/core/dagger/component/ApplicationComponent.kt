package com.ozantopuz.powerfulAndroid.core.dagger.component

import com.ozantopuz.powerfulAndroid.app.App
import com.ozantopuz.powerfulAndroid.core.dagger.module.ActivityBindingModule
import com.ozantopuz.powerfulAndroid.core.dagger.module.ApplicationModule
import com.ozantopuz.powerfulAndroid.core.dagger.module.DatabaseModule
import com.ozantopuz.powerfulAndroid.core.dagger.module.NetworkModule
import com.ozantopuz.powerfulAndroid.core.dagger.viewmodel.ViewModelModule
import com.ozantopuz.powerfulAndroid.data.dagger.ApiModule
import com.ozantopuz.powerfulAndroid.data.dagger.RepositoryModule
import com.ozantopuz.powerfulAndroid.data.dagger.ServiceModule
import com.ozantopuz.powerfulAndroid.data.dagger.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class, DatabaseModule::class,
    RepositoryModule::class,
    NetworkModule::class,
    ApiModule::class,
    ServiceModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
    ActivityBindingModule::class
])

interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): ApplicationComponent
    }
}