package com.ozantopuz.powerfulAndroid.core.dagger.module

import android.content.Context
import com.google.gson.Gson
import com.ozantopuz.powerfulAndroid.BuildConfig
import com.ozantopuz.powerfulAndroid.core.client.http.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    @Named("IsDebug")
    internal fun provideIsDebug() = BuildConfig.DEBUG

    @Provides
    @Named("Endpoint")
    internal fun provideEndpoint(): HttpUrl = HttpUrl.parse(BuildConfig.API_ENDPOINT)!!


    @Provides
    internal fun provideHttpClient(context: Context, @Named("IsDebug") isDebug: Boolean,
                                   interceptor: HeaderInterceptor,
                                   logginInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        var builder = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        if(isDebug) {
            builder.addInterceptor(logginInterceptor)
        }

        return builder.build()
    }

    @Provides
    internal fun provideHeaderInterceptor(): HeaderInterceptor {
        return HeaderInterceptor()
    }

    @Provides
    internal fun provideLogginInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    internal fun provideConverter(): Converter.Factory = GsonConverterFactory.create(Gson())

    @Provides
    internal fun provideRxCallAdapterFactory(): CallAdapter.Factory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    internal fun provideRestAdapterBuilder(client: OkHttpClient, converterFactory: Converter.Factory, factory: CallAdapter.Factory): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(factory)
    }

    @Provides
    fun provideRetrofit(@Named("Endpoint") endpoint: HttpUrl, builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(endpoint).build()
    }
}