package com.socialseller.panditji.UI.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.ChatListItem
import com.socialseller.panditji.UI.adapter.chat.ChatAdapter

class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        val chatItems = listOf(
            ChatListItem.DateHeader("Today"),
            ChatListItem.ChatMessage("User Name", "Thanks a bunch! Have a great day! 😊", "10:25", 5),
            ChatListItem.ChatMessage("User Name", "Thanks a bunch! Have a great day! 😊", "10:25", 5),
            ChatListItem.DateHeader("Yesterday"),
            ChatListItem.ChatMessage("User Name", "Thanks again!", "20:10", 0),
            ChatListItem.ChatMessage("User Name", "Thanks a bunch! Have a great day! 😊", "10:25", 1),
            ChatListItem.ChatMessage("User Name", "Thanks a bunch! Have a great day! 😊", "10:25", 2),
            ChatListItem.DateHeader("04/05/2025"),
            ChatListItem.ChatMessage("User Name", "Old message", "20:10", 0),
            ChatListItem.ChatMessage("User Name", "Thanks a bunch! Have a great day! 😊", "10:25", 0),
            ChatListItem.ChatMessage("User Name", "Thanks a bunch! Have a great day! 😊", "10:25", 0),
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ChatAdapter(chatItems) { chatMessage ->
            val fragment = ChattingFragment()  // Replace with your actual fragment
            val bundle = Bundle().apply {
                putString("userName", chatMessage.userName)
            }
            fragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment) // Replace with your container ID
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter

        return view
    }
}
