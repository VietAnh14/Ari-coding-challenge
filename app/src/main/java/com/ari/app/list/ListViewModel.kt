package com.ari.app.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ari.app.data.AppRepo
import com.ari.app.data.PokemonInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val PAGE_SIZE = 20

@HiltViewModel
class ListViewModel @Inject constructor(val appRepo: AppRepo) : ViewModel() {
    private val errorChannel = Channel<Throwable>(1)
    val errors = errorChannel.receiveAsFlow()

    val pokeList = MutableStateFlow<List<PokemonInfo>?>(null)
    private var loadingJob: Job? = null

    init {
        loadList(0)
    }

    fun loadMoreItems() {
        loadList(pokeList.value?.size ?: return)
    }

    private fun loadList(offset: Int) {
        if (loadingJob?.isActive == true) return

        loadingJob = viewModelScope.launch(Dispatchers.Default) {
            try {
                val data = appRepo.getPokemonList(offset, PAGE_SIZE)
                val currentList = pokeList.value
                pokeList.value = if (currentList == null) data else currentList + data
            } catch (e: CancellationException) {
                throw e
            } catch (e: Throwable) {
                e.printStackTrace()
                errorChannel.trySendBlocking(e)
            }
        }
    }
}