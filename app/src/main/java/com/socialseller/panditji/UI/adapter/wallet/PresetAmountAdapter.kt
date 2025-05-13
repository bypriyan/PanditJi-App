package com.socialseller.panditji.UI.adapter.wallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R

class PresetAmountAdapter(
    private val amounts: List<Int>,
    private val onAmountClick: (Int) -> Unit
) : RecyclerView.Adapter<PresetAmountAdapter.AmountViewHolder>() {

    inner class AmountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAmount: TextView = itemView.findViewById(R.id.tvAmount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmountViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_preset_amount, parent, false)
        return AmountViewHolder(view)
    }

    override fun onBindViewHolder(holder: AmountViewHolder, position: Int) {
        val amount = amounts[position]
        holder.tvAmount.text = amount.toString()
        holder.itemView.setOnClickListener { onAmountClick(amount) }
    }

    override fun getItemCount(): Int = amounts.size
}
