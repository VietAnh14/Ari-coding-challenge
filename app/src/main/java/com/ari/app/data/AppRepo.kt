package com.ari.app.data

import javax.inject.Inject

class AppRepo @Inject constructor(private val api: ApiService) {

    suspend fun getPokemonList(offset: Int, limit: Int): List<PokemonInfo> {
        return api.getPokemonList(offset, limit).results.map { it.toPokemonInfo() }
    }
}