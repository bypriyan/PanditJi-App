package com.socialseller.panditji.UI.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.WalletTransaction
import com.socialseller.panditji.UI.adapter.wallet.TransactionAdapter
import com.socialseller.panditji.UI.home.Wallet.RequestFragment
import com.socialseller.panditji.UI.home.Wallet.TransactionFragment
import com.socialseller.panditji.UI.home.Wallet.WithdrawFragment
import com.socialseller.panditji.UI.notification.NotificationFragment

class WalletFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var btnWithdrawMoney: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_wallet, container, false)
        btnWithdrawMoney = view?.findViewById(R.id.btnWithdrawMoney)!!
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabLayout = view.findViewById(R.id.tabLayout)

        // Add tabs
        tabLayout.addTab(tabLayout.newTab().setText("Transaction").setIcon(R.drawable.transaction))
        tabLayout.addTab(tabLayout.newTab().setText("Request").setIcon(R.drawable.credit))

        // Default tab
        childFragmentManager.beginTransaction()
            .replace(R.id.tabContainer, TransactionFragment())
            .commit()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val fragment = when (tab.position) {
                    0 -> TransactionFragment()
                    1 -> RequestFragment()
                    else -> TransactionFragment()
                }
                childFragmentManager.beginTransaction()
                    .replace(R.id.tabContainer, fragment)
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        btnWithdrawMoney.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, WithdrawFragment())
                .addToBackStack(null)
                .commit()
        }


    }
}

