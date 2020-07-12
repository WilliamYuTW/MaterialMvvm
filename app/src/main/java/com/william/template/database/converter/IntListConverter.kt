package com.william.template.database.converter

import androidx.room.TypeConverter

/**
 * @author WeiYi Yu
 * @date 2020-07-12
 */
internal class IntegerListConverter {
    @TypeConverter
    fun fromString(value: String): List<Int>? {
        return value.split(",").map {
            it.toInt()
        }.toList()
    }

    @TypeConverter
    fun fromList(list: List<Int>): String {
        return list.joinToString(",")
    }
}
