package com.socialseller.panditji.UI.adapter.wallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R

class UpiOptionAdapter(
    private val icons: List<Int>,
    private val onUpiClick: (Int) -> Unit
) : RecyclerView.Adapter<UpiOptionAdapter.UpiViewHolder>() {

    inner class UpiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgUpi: ImageView = itemView.findViewById(R.id.imgUpi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_upi_option, parent, false)
        return UpiViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpiViewHolder, position: Int) {
        holder.imgUpi.setImageResource(icons[position])
        holder.itemView.setOnClickListener { onUpiClick(icons[position]) }
    }

    override fun getItemCount(): Int = icons.size
}
