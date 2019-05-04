package com.ozantopuz.powerfulAndroid.data.dagger

import com.ozantopuz.powerfulAndroid.data.repository.MovieRepository
import com.ozantopuz.powerfulAndroid.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideMovieRepository(repository: MovieRepositoryImpl): MovieRepository
}