package com.ari.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.viewbinding.ViewBinding
import com.ari.app.R

abstract class BaseFragment<B: ViewBinding>: Fragment() {
    private var _binding: B? = null
    val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return createBinding(inflater, container)
            .also { _binding = it }
            .root
    }

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): B

    protected fun pushFragment(fragment: Fragment, tag: String?) {
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, fragment, tag)
            addToBackStack(null)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}