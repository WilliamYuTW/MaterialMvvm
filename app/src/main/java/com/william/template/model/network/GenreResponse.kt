package com.william.template.model.network

import com.squareup.moshi.Json
import com.william.template.model.database.DatabaseGenre

/**
 * @author WeiYi Yu
 * @date 2020-07-08
 */

data class GenreResponse(
    @Json(name = "genres") val genres: List<Genre>
) {
    data class Genre(
        @Json(name = "id") val id: Int,
        @Json(name = "name") val name: String
    )
}

fun GenreResponse.asDatabaseModel(): Array<DatabaseGenre> {
    return genres.map {
        DatabaseGenre(
            id = it.id,
            name = it.name
        )
    }.toTypedArray()
}