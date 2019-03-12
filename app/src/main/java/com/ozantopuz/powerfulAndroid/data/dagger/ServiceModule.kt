package com.ozantopuz.powerfulAndroid.data.dagger

import com.ozantopuz.powerfulAndroid.data.service.MovieService
import com.ozantopuz.powerfulAndroid.data.service.MovieServiceImp
import dagger.Binds
import dagger.Module

@Module
abstract class ServiceModule {

    @Binds
    abstract fun provideMovieService(service: MovieServiceImp): MovieService
}