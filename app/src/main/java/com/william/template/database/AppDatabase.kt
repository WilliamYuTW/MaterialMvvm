package com.william.template.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.william.template.model.database.DatabaseMovie

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */

@Database(entities = [DatabaseMovie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}