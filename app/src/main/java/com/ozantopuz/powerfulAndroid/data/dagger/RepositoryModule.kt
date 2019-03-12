package com.ozantopuz.powerfulAndroid.data.dagger

import com.ozantopuz.powerfulAndroid.data.repository.MovieRepository
import com.ozantopuz.powerfulAndroid.data.repository.MovieRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideMovieRepository(repository: MovieRepositoryImp): MovieRepository
}