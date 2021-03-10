package com.georgcantor.instagramclone.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}