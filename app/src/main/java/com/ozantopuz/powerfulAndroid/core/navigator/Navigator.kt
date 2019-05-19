package com.ozantopuz.powerfulAndroid.core.navigator

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.ozantopuz.powerfulAndroid.core.extensions.ignoreNull

object Navigator{

    inline fun <reified T : Activity> Context.open() =  startActivity(Intent(this, T::class.java))

    inline fun <reified T : Activity> Context.openWithId(id : Int?) {
        val i = Intent(this, T::class.java)
        i.putExtra("id", id.ignoreNull())
        startActivity(i)
    }

    inline fun <reified T : Activity> Activity.clearAndOpen() {
        val i = Intent(this, T::class.java)
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK and Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(i)
        this.finish()
    }
}