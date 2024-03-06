package com.ari.app.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.ari.app.data.model.PokemonInfo
import com.ari.app.databinding.ItemPokemonBinding

class PokeListAdapter(private val listener: Listener): ListAdapter<PokemonInfo, PokeListAdapter.PokemonViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener {
        fun onItemClick(item: PokemonInfo)
    }

    class DiffCallBack: DiffUtil.ItemCallback<PokemonInfo>() {
        override fun areItemsTheSame(oldItem: PokemonInfo, newItem: PokemonInfo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PokemonInfo, newItem: PokemonInfo): Boolean {
            return oldItem == newItem
        }
    }

    class PokemonViewHolder(private val binding: ItemPokemonBinding, listener: Listener): ViewHolder(binding.root) {
        private var boundItem: PokemonInfo? = null

        init {
            binding.card.setOnClickListener {
                listener.onItemClick(boundItem ?: return@setOnClickListener)
            }
        }

        fun bind(item: PokemonInfo) {
            boundItem = item
            binding.pokemonImage.load(item.imageUrl) {
                crossfade(true)
            }
            binding.name.text = item.name
        }
    }
}