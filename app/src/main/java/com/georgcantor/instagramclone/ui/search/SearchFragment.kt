package com.georgcantor.instagramclone.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.databinding.FragmentSearchBinding
import org.koin.android.ext.android.inject

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var binding: FragmentSearchBinding? = null
    private val viewModel by inject<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        val manager = GridLayoutManager(requireContext(), 3)

        binding?.searchRecycler?.layoutManager = manager

        viewModel.pictures.observe(viewLifecycleOwner) {
            binding?.searchRecycler?.adapter = SearchAdapter(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}