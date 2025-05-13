package com.socialseller.panditji.UI.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.Review
import com.socialseller.panditji.UI.adapter.notification.NotificationAdapter
import com.socialseller.panditji.UI.adapter.review.ReviewAdapter

class NotificationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reviewList = listOf(
            Review("New Review received", "Chat ended with pandit jii name please rate and review your chat"),
            Review("Money Withdrawal", "We have added balance in your wallet."),
            Review("Announcement", "Our service will be down tomorrow for planned maintainence")
        )

        val reviewrecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        reviewrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        reviewrecyclerView.adapter = NotificationAdapter(reviewList)
    }

}