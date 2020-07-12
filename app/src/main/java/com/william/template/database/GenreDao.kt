package com.william.template.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.william.template.model.database.DatabaseGenre

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */
@Dao
interface GenreDao {
    @Query("select * from genre_table")
    fun getGenres(): LiveData<List<DatabaseGenre>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg genres: DatabaseGenre)
}