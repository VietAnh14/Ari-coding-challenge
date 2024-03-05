package com.ari.app.data

import com.ari.app.data.remote.PokeListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokeListResponse
}