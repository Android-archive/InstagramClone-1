package com.georgcantor.instagramclone.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.databinding.FragmentHomeBinding
import com.georgcantor.instagramclone.ui.home.adapter.FeedAdapter
import com.georgcantor.instagramclone.util.shortToast
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null
    private val viewModel by inject<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val manager = LinearLayoutManager(requireContext())

        val adapter = FeedAdapter {
            context?.shortToast(it?.user ?: "none")
        }

        binding?.feedRecycler?.layoutManager = manager
        binding?.feedRecycler?.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getPictures().collectLatest {
                adapter.submitData(it)
            }
        }

//        viewModel.pictures.observe(viewLifecycleOwner) {
//            binding?.headerRecycler?.adapter = HeaderAdapter(it)
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}