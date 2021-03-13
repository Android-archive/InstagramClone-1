package com.georgcantor.instagramclone.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.databinding.FragmentHomeBinding
import com.georgcantor.instagramclone.ui.home.adapter.FeedAdapter
import com.georgcantor.instagramclone.ui.home.adapter.HeaderAdapter
import com.georgcantor.instagramclone.util.shortToast
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null
    private val viewModel by inject<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding?.toolbar?.apply {
            inflateMenu(R.menu.main_menu)
            setOnMenuItemClickListener { context?.shortToast("direct"); true }
        }

        viewModel.pictures.observe(viewLifecycleOwner) {
            binding?.headerRecycler?.adapter = HeaderAdapter(it)
            binding?.feedRecycler?.adapter = FeedAdapter(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}