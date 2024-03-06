package com.ari.app.data.remote

import com.ari.app.data.remote.PokeListResponse
import com.ari.app.data.remote.PokemonDetaiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v2/pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokeListResponse

    @GET("v2/pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetaiResponse
}