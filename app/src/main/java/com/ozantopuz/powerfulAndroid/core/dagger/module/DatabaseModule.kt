package com.ozantopuz.powerfulAndroid.core.dagger.module

import android.content.Context
import androidx.room.Room
import com.ozantopuz.powerfulAndroid.core.database.AppDatabase
import com.ozantopuz.powerfulAndroid.core.utils.Constants
import com.ozantopuz.powerfulAndroid.data.dao.MovieDao
import dagger.Module
import dagger.Provides


@Module
object DatabaseModule {

    @JvmStatic
    @Provides
    fun providesRoomDatabase(context : Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME).build()
    }

    @JvmStatic
    @Provides
    fun providesProductDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }
}