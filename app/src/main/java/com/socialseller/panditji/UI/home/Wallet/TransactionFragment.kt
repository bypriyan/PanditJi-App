package com.socialseller.panditji.UI.home.Wallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.WalletTransaction
import com.socialseller.panditji.UI.adapter.wallet.TransactionAdapter

class TransactionFragment : Fragment() {

    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var rvTransactions: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvTransactions = view.findViewById(R.id.rvTransactions)
        rvTransactions.layoutManager = LinearLayoutManager(requireContext())

        val transactions = listOf(
            WalletTransaction("Withdrawal", "₹500", "3:05PM - Aug 22, 2029", R.drawable.moneytransfer),
            WalletTransaction("Credited", "₹500", "3:05PM - Aug 22, 2029", R.drawable.debit_icon),
            WalletTransaction("Withdrawal", "₹500", "3:05PM - Aug 21, 2029", R.drawable.moneytransfer),
            WalletTransaction("Withdrawal", "₹500", "3:05PM - Aug 22, 2029", R.drawable.moneytransfer),
            WalletTransaction("Credited", "₹500", "3:05PM - Aug 22, 2029", R.drawable.debit_icon),
            WalletTransaction("Withdrawal", "₹500", "3:05PM - Aug 21, 2029", R.drawable.moneytransfer)
        )

        transactionAdapter = TransactionAdapter(transactions)
        rvTransactions.adapter = transactionAdapter
    }
}
