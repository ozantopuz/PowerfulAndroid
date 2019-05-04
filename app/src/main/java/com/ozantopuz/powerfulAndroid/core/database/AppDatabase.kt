package com.ozantopuz.powerfulAndroid.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ozantopuz.powerfulAndroid.data.dao.MovieDao
import com.ozantopuz.powerfulAndroid.data.entity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}