package com.ozantopuz.powerfulAndroid.data.dagger

import com.ozantopuz.powerfulAndroid.data.service.MovieApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    internal fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
}