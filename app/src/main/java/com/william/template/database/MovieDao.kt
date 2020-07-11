package com.william.template.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.william.template.model.database.DatabaseMovie

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */
@Dao
interface MovieDao {
    @Query("select * from movie_table")
    fun getMovies(): LiveData<List<DatabaseMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg movies: DatabaseMovie)
}