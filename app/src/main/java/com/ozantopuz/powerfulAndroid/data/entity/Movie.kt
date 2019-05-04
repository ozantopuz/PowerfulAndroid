package com.ozantopuz.powerfulAndroid.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(

    @field:PrimaryKey
    @SerializedName("id")
    @Expose
    var id : Int? = null,

    @SerializedName("vote_count")
    @Expose
    var voteCount: Double? = null,

    @SerializedName("vote_average")
    @Expose
    var voteAverage : Double? = null,

    @SerializedName("title")
    @Expose
    var title : String? = null,

    @SerializedName("popularity")
    @Expose
    var popularity : Double? = null,

    @SerializedName("poster_path")
    @Expose
    var posterPath : String? = null,

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath : String? = null,

    @SerializedName("overview")
    @Expose
    var overview : String? = null,

    @SerializedName("release_date")
    @Expose
    var releaseDate : String? = null
)