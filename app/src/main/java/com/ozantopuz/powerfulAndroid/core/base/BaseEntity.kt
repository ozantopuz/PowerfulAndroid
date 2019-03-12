package com.ozantopuz.powerfulAndroid.core.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseEntity<T> (
    @SerializedName("page")
    @Expose
    var page: Int? = null,
    @SerializedName("total_results")
    @Expose
    var totalResults: String? = null,
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null,
    @SerializedName("results")
    @Expose
    var results: List<T>? = null
)