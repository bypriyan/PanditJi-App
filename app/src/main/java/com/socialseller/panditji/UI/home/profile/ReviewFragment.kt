package com.socialseller.panditji.UI.home.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.ReviewModel2
import com.socialseller.panditji.UI.adapter.review.ReviewAdapter2


class ReviewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReviewAdapter2
    private lateinit var reviewList: List<ReviewModel2>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.reviewRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        reviewList = listOf(
            ReviewModel2("John Kevin", 4.5f, "Astrologer  gently answered to my questions and shared remedial advise which would create good vibes for marital prosperity with my husband", R.drawable.temp_profile_image),
            ReviewModel2("Priya Sharma", 5f, "Astrologer  gently answered to my questions and shared remedial advise which would create good vibes for marital prosperity with my husband", R.drawable.temp_profile_image),
            ReviewModel2("Amit Rao", 4f, "Astrologer  gently answered to my questions and shared remedial advise which would create good vibes for marital prosperity with my husband", R.drawable.temp_profile_image),
            ReviewModel2("John Kevin", 4.5f, "Astrologer  gently answered to my questions and shared remedial advise which would create good vibes for marital prosperity with my husband", R.drawable.temp_profile_image),
            ReviewModel2("Priya Sharma", 5f, "Astrologer  gently answered to my questions and shared remedial advise which would create good vibes for marital prosperity with my husband", R.drawable.temp_profile_image),
            ReviewModel2("Amit Rao", 4f, "Astrologer  gently answered to my questions and shared remedial advise which would create good vibes for marital prosperity with my husband", R.drawable.temp_profile_image)
        )

        adapter = ReviewAdapter2(reviewList)
        recyclerView.adapter = adapter

        val filterButton: View = view.findViewById(R.id.btnFilter)
        filterButton.setOnClickListener {
            val bottomSheet = FilterDialogFragment()
            bottomSheet.show(parentFragmentManager, bottomSheet.tag)
        }
        val sortButton: View = view.findViewById(R.id.btnSort)
        sortButton.setOnClickListener {
            val sortBottomSheet = SortBottomSheetDialogFragment()
            sortBottomSheet.show(parentFragmentManager, sortBottomSheet.tag)
        }


    }
}
