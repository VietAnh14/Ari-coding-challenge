package com.ari.app.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ari.app.base.BaseFragment
import com.ari.app.data.model.PokemonInfo
import com.ari.app.databinding.FragmentListBinding
import com.ari.app.details.DetailFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment: BaseFragment<FragmentListBinding>(), PokeListAdapter.Listener {

    private val viewModel by viewModels<ListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PokeListAdapter(this)
        with(binding.recycler) {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            setAdapter(adapter)
            addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val lm = recyclerView.layoutManager as? LinearLayoutManager ?: return
                    if (lm.findLastVisibleItemPosition() > lm.itemCount - 4) {
                        viewModel.loadMoreItems()
                    }
                }
            })
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pokeList.collect {
                adapter.submitList(it)
                setLoading(it == null)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.errors.collect {
                    //TODO: Make loading a state
                    setLoading(false)
                    Snackbar.make(binding.root, "Something went wrongs", Snackbar.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun setLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.recycler.isVisible = false
            binding.progressCircular.show()
        } else {
            binding.recycler.isVisible = true
            binding.progressCircular.hide()
        }
    }

    override fun onItemClick(item: PokemonInfo) {
        pushFragment(DetailFragment.newInstance(item.id), null)
    }

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding {
        return FragmentListBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}