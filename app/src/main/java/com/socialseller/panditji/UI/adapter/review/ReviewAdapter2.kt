package com.socialseller.panditji.UI.adapter.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.ReviewModel2

class ReviewAdapter2(private val reviews: List<ReviewModel2>) :
    RecyclerView.Adapter<ReviewAdapter2.ReviewViewHolder>() {

    inner class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ShapeableImageView = itemView.findViewById(R.id.profile_image)
        val textName: TextView = itemView.findViewById(R.id.textName)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val textReview: TextView = itemView.findViewById(R.id.textReview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = reviews[position]
        holder.textName.text = review.name
        holder.ratingBar.rating = review.rating
        holder.textReview.text = review.review
        holder.imageView.setImageResource(review.imageResId)
    }

    override fun getItemCount(): Int = reviews.size
}
