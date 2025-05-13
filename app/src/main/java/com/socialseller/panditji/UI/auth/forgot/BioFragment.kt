package com.socialseller.panditji.UI.auth.forgot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.socialseller.panditji.R
import com.socialseller.panditji.databinding.FragmentBioBinding
import com.socialseller.panditji.databinding.FragmentOTPBinding

class BioFragment : Fragment() {

    private var _binding: FragmentBioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBioBinding.inflate(inflater, container, false)
        return binding.root
    }


}