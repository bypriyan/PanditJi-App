package com.socialseller.panditji.UI.adapter.review

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.Review
import android.view.LayoutInflater

class ReviewAdapter(private val reviews: List<Review>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    inner class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvReviewText: TextView = itemView.findViewById(R.id.tvReviewText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]
        holder.tvUserName.text = review.userName
        holder.tvReviewText.text = review.reviewText
    }

    override fun getItemCount(): Int = reviews.size
}
