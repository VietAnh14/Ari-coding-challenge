package com.ari.app.data

import com.ari.app.data.model.PokemonDetail
import com.ari.app.data.model.PokemonInfo
import com.ari.app.data.remote.ApiService
import javax.inject.Inject

class AppRepo @Inject constructor(private val api: ApiService) {

    suspend fun getPokemonList(offset: Int, limit: Int): List<PokemonInfo> {
        return api.getPokemonList(offset, limit).results.map { it.toPokemonInfo() }
    }

    suspend fun getPokemonDetail(id: Int): PokemonDetail {
        return api.getPokemonDetail(id).toPokemonDetail()
    }
}