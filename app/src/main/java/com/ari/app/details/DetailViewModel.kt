package com.ari.app.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ari.app.data.AppRepo
import com.ari.app.data.model.PokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val appRepo: AppRepo,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val pokemonDetail = MutableStateFlow<PokemonDetail?>(null)

    init {
        loadDetail()
    }

    fun loadDetail() {
        viewModelScope.launch {
            try {
                val id = requireNotNull(savedStateHandle.get<Int>(DetailFragment.ARG_ID))
                pokemonDetail.value = appRepo.getPokemonDetail(id)
            } catch (e: CancellationException) {
                throw e
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}