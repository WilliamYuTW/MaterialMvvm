package com.william.template.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author WeiYi Yu
 * @date 2020-07-11
 */

@Entity(tableName = "genre_table")
data class DatabaseGenre(
    @PrimaryKey val id: Int,
    val name: String
)