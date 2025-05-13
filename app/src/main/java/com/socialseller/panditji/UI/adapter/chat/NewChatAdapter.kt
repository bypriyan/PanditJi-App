package com.socialseller.panditji.UI.adapter.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.NewChatModel

class NewChatAdapter(private val chatList: List<NewChatModel>) :
    RecyclerView.Adapter<NewChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val messageText: TextView = itemView.findViewById(R.id.messageText)
        val timeText: TextView = itemView.findViewById(R.id.timeText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.nameText.text = chat.name
        holder.messageText.text = chat.message
        holder.timeText.text = chat.time
        // You can also load profileImage using Glide or Picasso if needed
    }

    override fun getItemCount(): Int = chatList.size
}