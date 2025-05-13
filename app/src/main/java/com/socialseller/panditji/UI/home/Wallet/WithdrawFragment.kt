package com.socialseller.panditji.UI.home.Wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.adapter.wallet.PresetAmountAdapter
import com.socialseller.panditji.UI.adapter.wallet.UpiOptionAdapter
import com.socialseller.panditji.databinding.FragmentWithdrawBinding

class WithdrawFragment : Fragment() {

    private var _binding: FragmentWithdrawBinding? = null
    private val binding get() = _binding!!

    private lateinit var presetAmountAdapter: PresetAmountAdapter
    private lateinit var upiOptionAdapter: UpiOptionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWithdrawBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnWithdraw.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, WithdrawSuccessFragment())
                .addToBackStack(null)
                .commit()
        }

        setupPresetAmounts()
        setupUpiOptions()
    }

    private fun setupPresetAmounts() {
        val amounts = listOf(100, 200, 300, 500, 1000)

        presetAmountAdapter = PresetAmountAdapter(amounts) { amount ->
            binding.yourAmountEditText.setText(amount.toString())
        }

        binding.recyclerPresetAmounts.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = presetAmountAdapter
        }
    }

    private fun setupUpiOptions() {
        val upiIcons = listOf(R.drawable.paytm, R.drawable.phonepe, R.drawable.googlepay)

        upiOptionAdapter = UpiOptionAdapter(upiIcons) { selectedIconRes ->
        }

        binding.recyclerUpiOptions.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = upiOptionAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
