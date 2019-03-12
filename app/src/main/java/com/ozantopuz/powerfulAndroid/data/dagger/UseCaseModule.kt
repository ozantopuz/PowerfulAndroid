package com.ozantopuz.powerfulAndroid.data.dagger

import com.ozantopuz.powerfulAndroid.data.usecase.MovieUseCase
import com.ozantopuz.powerfulAndroid.data.usecase.MovieUseCaseImp
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun provideMovieUseCase(usecase: MovieUseCaseImp): MovieUseCase
}