package com.ozantopuz.powerfulAndroid.data.usecase

import com.ozantopuz.powerfulAndroid.data.service.MovieService
import javax.inject.Inject

class MovieUseCaseImp @Inject constructor(private val service: MovieService): MovieUseCase {

    override fun getTopRated(apiKey: String, language: String, page: Int) = service.getTopRated(apiKey, language, page)
}