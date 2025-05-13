package com.socialseller.panditji.UI.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.home.Wallet.WithdrawSuccessFragment
import com.socialseller.panditji.UI.home.profile.EditProfileFragment
import com.socialseller.panditji.UI.home.profile.HelpSupportFragment
import com.socialseller.panditji.UI.home.profile.PricingSetupFragment
import com.socialseller.panditji.UI.home.profile.ProfessioanlInfoFragment
import com.socialseller.panditji.UI.home.profile.ReviewFragment
import com.socialseller.panditji.databinding.FragmentProfileBinding
import com.socialseller.panditji.databinding.FragmentWithdrawBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.accountRating.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ReviewFragment())
                .addToBackStack(null)
                .commit()
        }
//        binding.professionalInfo.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment, ProfessioanlInfoFragment())
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.pricingSetup.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment, PricingSetupFragment())
//                .addToBackStack(null)
//                .commit()
//        }
//        binding.help.setOnClickListener {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment, HelpSupportFragment())
//                .addToBackStack(null)
//                .commit()
//        }
        binding.editProfile.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, EditProfileFragment())
                .addToBackStack(null)
                .commit()
        }


    }
}