package com.william.template.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.william.template.database.converter.IntegerListConverter
import com.william.template.model.database.DatabaseGenre
import com.william.template.model.database.DatabaseMovie

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */

@Database(entities = [DatabaseMovie::class, DatabaseGenre::class], version = 1)
@TypeConverters(value = [IntegerListConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
    abstract val genreDao: GenreDao
}