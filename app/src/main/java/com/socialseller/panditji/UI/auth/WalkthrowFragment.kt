package com.socialseller.panditji.UI.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.socialseller.panditji.R
import com.socialseller.panditji.databinding.FragmentWalkthrowBinding


class WalkthrowFragment : Fragment(R.layout.fragment_walkthrow) {

    private var _binding: FragmentWalkthrowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentWalkthrowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            requestOTPBtn.setOnClickListener {
                findNavController().navigate(R.id.action_WalkthrowFragment_to_loginFragment)
            }
            previousBtn.setOnClickListener {
                findNavController().navigate(R.id.action_WalkthrowFragment_to_registrationFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}