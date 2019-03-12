package com.ozantopuz.powerfulAndroid.data.service

import com.ozantopuz.powerfulAndroid.core.client.http.base.BaseService
import javax.inject.Inject

class MovieServiceImp @Inject constructor(private val api: MovieApi): BaseService<MovieApi>(api), MovieService {

    override fun getTopRated(apiKey: String, language: String, page: Int) = api.getTopRated(apiKey, language, page)
}