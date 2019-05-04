package com.ozantopuz.powerfulAndroid.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ozantopuz.powerfulAndroid.core.extensions.addImageUrl
import com.ozantopuz.powerfulAndroid.core.extensions.ignoreNull

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url : String?) {
    try {
        if (!url.isNullOrEmpty()) Glide.with(imageView.context).load(url.addImageUrl()).into(imageView)
    } catch (e: Exception){ e.printStackTrace() }
}