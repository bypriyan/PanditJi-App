package com.socialseller.panditji.UI.adapter.wallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.WalletTransaction

class TransactionAdapter(private val items: List<WalletTransaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvType: TextView = itemView.findViewById(R.id.tvType)
        val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val ivIcon: ImageView = itemView.findViewById(R.id.ivIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = items[position]
        holder.tvType.text = item.type
        holder.tvTime.text = item.date
        holder.tvAmount.text = item.amount
        holder.ivIcon.setImageResource(item.iconRes)
    }

    override fun getItemCount() = items.size
}
