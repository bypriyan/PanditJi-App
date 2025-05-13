package com.socialseller.panditji.UI.adapter.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.MessageItem

class ChatMessageAdapter(private val messages: List<MessageItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_SENT = 1
        private const val TYPE_RECEIVED = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (messages[position]) {
            is MessageItem.SentMessage -> TYPE_SENT
            is MessageItem.ReceivedMessage -> TYPE_RECEIVED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_SENT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chat_right, parent, false)
                SentMessageViewHolder(view)
            }
            TYPE_RECEIVED -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chat_left, parent, false)
                ReceivedMessageViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = messages[position]) {
            is MessageItem.SentMessage -> (holder as SentMessageViewHolder).bind(item)
            is MessageItem.ReceivedMessage -> (holder as ReceivedMessageViewHolder).bind(item)
        }
    }

    class SentMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageText: TextView = view.findViewById(R.id.messageText)
        private val messageTime: TextView = view.findViewById(R.id.messageTime)

        fun bind(item: MessageItem.SentMessage) {
            messageText.text = item.text
            messageTime.text = item.time
        }
    }

    class ReceivedMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val messageText: TextView = view.findViewById(R.id.messageText)
        private val messageTime: TextView = view.findViewById(R.id.messageTime)

        fun bind(item: MessageItem.ReceivedMessage) {
            messageText.text = item.text
            messageTime.text = item.time
        }
    }
}
