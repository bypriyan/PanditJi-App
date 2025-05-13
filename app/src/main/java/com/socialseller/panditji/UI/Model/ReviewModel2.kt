package com.socialseller.panditji.UI.Model

data class ReviewModel2(
    val name: String,
    val rating: Float,
    val review: String,
    val imageResId: Int // You can use a drawable resource or URL if using Glide/Picasso
)
