package com.ozantopuz.powerfulAndroid.core.extensions

import com.ozantopuz.powerfulAndroid.data.entity.Movie

fun String?.ignoreNull() =  this ?: ""

fun Int?.ignoreNull() =  this ?: 0

fun Long?.ignoreNull() =  this ?: 0

fun Double?.ignoreNull() =  this ?: 0.0

fun Boolean?.ignoreNull() =  this ?: false

fun List<Movie>?.ignoreNull() =  this ?: listOf()