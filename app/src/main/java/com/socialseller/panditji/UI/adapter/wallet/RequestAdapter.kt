package com.socialseller.panditji.UI.adapter.wallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.WalletRequest

class RequestAdapter(private val requestList: List<WalletRequest>) :
    RecyclerView.Adapter<RequestAdapter.RequestViewHolder>() {

    inner class RequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvType: TextView = itemView.findViewById(R.id.tvType)
        val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
        val ivIcon: ImageView = itemView.findViewById(R.id.ivIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_request, parent, false)
        return RequestViewHolder(view)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        val request = requestList[position]
        holder.tvType.text = request.type
        holder.tvTime.text = request.time
        holder.tvAmount.text = request.amount
        holder.ivIcon.setImageResource(R.drawable.moneytransfer)
    }

    override fun getItemCount(): Int = requestList.size
}

