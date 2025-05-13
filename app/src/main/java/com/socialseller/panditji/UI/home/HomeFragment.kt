package com.socialseller.panditji.UI.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.NewChatModel
import com.socialseller.panditji.UI.Model.Review
import com.socialseller.panditji.UI.adapter.chat.NewChatAdapter
import com.socialseller.panditji.UI.adapter.review.ReviewAdapter
import com.socialseller.panditji.UI.notification.NotificationFragment

class HomeFragment : Fragment() {

    private lateinit var notificationIcon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        notificationIcon = view?.findViewById(R.id.notificationIcon)!!
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationIcon.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, NotificationFragment())
                .addToBackStack(null)
                .commit()
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.newChatsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val dummyList = listOf(
            NewChatModel("Pandit Name", "Thanks a bunch! Have a great day! 😊", "10:25"),
            NewChatModel("Pandit Name 2", "Hello, can you help me?", "11:15"),
            NewChatModel("Pandit Name 3", "Good luck!", "12:00")
        )

        val adapter = NewChatAdapter(dummyList)
        recyclerView.adapter = adapter

        val reviewList = listOf(
            Review("Anonymous", "Amazing astrologer mostly all doubts are clear."),
            Review("User123", "Very helpful and insightful."),
            Review("Nikki", "Highly recommended.")
        )

        val reviewrecyclerView = view.findViewById<RecyclerView>(R.id.reviewRecyclerView)
        reviewrecyclerView.layoutManager = LinearLayoutManager(requireContext())
        reviewrecyclerView.adapter = ReviewAdapter(reviewList)
    }


}