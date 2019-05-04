package com.ozantopuz.powerfulAndroid.core.extensions

fun String?.addImageUrl() = "https://image.tmdb.org/t/p/w500/${this.ignoreNull()}"
