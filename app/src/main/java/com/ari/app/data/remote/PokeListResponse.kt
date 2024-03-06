package com.ari.app.data.remote


import com.ari.app.data.model.PokemonInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokeListResponse(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "previous")
    val previous: Any?,
    @Json(name = "results")
    val results: List<Result>
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "name")
        val name: String,
        @Json(name = "url")
        val url: String
    ) {
        fun toPokemonInfo(): PokemonInfo {
            val id = url.removeSuffix("/")
                .substringAfterLast('/')
                .toInt()
            return PokemonInfo(
                id = id,
                name = name,
                url = url,
                imageUrl = id.asPokemonImageUrl()
            )
        }
    }
}

fun Int.asPokemonImageUrl(): String {
    return "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${this.toString().padStart(3, '0')}.png"
}