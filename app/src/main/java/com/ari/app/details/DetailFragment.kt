package com.ari.app.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.ari.app.base.BaseFragment
import com.ari.app.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment: BaseFragment<FragmentDetailBinding>() {
    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pokemonDetail.filterNotNull().collect {
                binding.image.load(it.imageUrl) { crossfade(true) }
                binding.name.text = it.name
                binding.height.text = "${it.height} cm"
                binding.weight.text = "${it.weight} kg"
            }
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(layoutInflater, container, false)
    }


    companion object {
        const val ARG_ID = "pokemon_id"

        fun newInstance(pokemonId: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf(
                    ARG_ID to pokemonId
                )
            }
        }
    }
}