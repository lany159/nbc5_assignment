package com.example.nbc6application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nbc6application.databinding.FragmentDetailBinding
import com.example.nbc6application.databinding.FragmentMainBinding


class DetailFragment : Fragment() {

    private var _binding : FragmentDetailBinding? = null
    private val binding : FragmentDetailBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

}