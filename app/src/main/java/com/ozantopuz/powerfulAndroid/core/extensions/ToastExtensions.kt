package com.ozantopuz.powerfulAndroid.core.extensions

import android.content.Context
import android.widget.Toast

fun Context.toast(message : String?) =  Toast.makeText(this, message.ignoreNull(), Toast.LENGTH_SHORT).show()
