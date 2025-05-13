package com.socialseller.panditji.UI.adapter.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.Review

class NotificationAdapter(private val reviews: List<Review>) :
    RecyclerView.Adapter<NotificationAdapter.ReviewViewHolder>() {

    inner class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvReviewText: TextView = itemView.findViewById(R.id.tvReviewText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_notification, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]
        holder.tvUserName.text = review.userName
        holder.tvReviewText.text = review.reviewText
    }

    override fun getItemCount(): Int = reviews.size
}