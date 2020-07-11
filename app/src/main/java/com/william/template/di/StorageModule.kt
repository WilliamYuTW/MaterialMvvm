package com.william.template.di

import android.content.Context
import androidx.room.Room
import com.tencent.mmkv.MMKV
import com.william.template.R
import com.william.template.database.AppDatabase
import com.william.template.database.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

@Module
@InstallIn(ApplicationComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideMmkv(@ApplicationContext applicationContext: Context): MMKV {
        MMKV.initialize(applicationContext)
        return MMKV.defaultMMKV()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            applicationContext.getString(R.string.database_name)
        )
            // Wipes and rebuilds instead of migrating if no Migration object.
            // Migration is not part of this lesson. You can learn more about
            // migration with Room in this blog post:
            // https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao
    }
}