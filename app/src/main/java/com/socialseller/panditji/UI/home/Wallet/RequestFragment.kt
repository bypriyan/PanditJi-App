package com.socialseller.panditji.UI.home.Wallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.WalletRequest
import com.socialseller.panditji.UI.adapter.wallet.RequestAdapter

class RequestFragment : Fragment() {

    private lateinit var requestAdapter: RequestAdapter
    private lateinit var rvRequest: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvRequest = view.findViewById(R.id.rvRequest)
        rvRequest.layoutManager = LinearLayoutManager(requireContext())

        val requests = listOf(
            WalletRequest("Withdrawal", "3:05PM - Aug 22, 2029", "₹500"),
            WalletRequest("Withdrawal", "3:05PM - Aug 21, 2029", "₹500"),
            WalletRequest("Withdrawal", "3:05PM - Aug 22, 2029", "₹500"),
            WalletRequest("Withdrawal", "3:05PM - Aug 21, 2029", "₹500"),
            WalletRequest("Withdrawal", "3:05PM - Aug 22, 2029", "₹500"),
            WalletRequest("Withdrawal", "3:05PM - Aug 21, 2029", "₹500")
        )

        requestAdapter = RequestAdapter(requests)
        rvRequest.adapter = requestAdapter
    }
}
