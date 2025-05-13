package com.socialseller.panditji.UI.adapter.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.socialseller.panditji.R
import com.socialseller.panditji.UI.Model.ChatListItem

class ChatAdapter(
    private val items: List<ChatListItem>,
    private val onChatClick: (ChatListItem.ChatMessage) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        private const val VIEW_TYPE_DATE_HEADER = 0
        private const val VIEW_TYPE_CHAT_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ChatListItem.DateHeader -> VIEW_TYPE_DATE_HEADER
            is ChatListItem.ChatMessage -> VIEW_TYPE_CHAT_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_DATE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_date_header, parent, false)
            DateHeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_chat_list, parent, false)
            ChatViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ChatListItem.DateHeader -> (holder as DateHeaderViewHolder).bind(item)
            is ChatListItem.ChatMessage -> (holder as ChatViewHolder).bind(item, onChatClick)
        }
    }

    override fun getItemCount(): Int = items.size

    class DateHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDateHeader: TextView = itemView.findViewById(R.id.tvDateHeader)

        fun bind(item: ChatListItem.DateHeader) {
            tvDateHeader.text = item.dateLabel
        }
    }

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName: TextView = itemView.findViewById(R.id.categoryName)
        private val message: TextView = itemView.findViewById(R.id.textView7)
        private val time: TextView = itemView.findViewById(R.id.time)
        private val unreadBadge: TextView = itemView.findViewById(R.id.unreadBadge)
        private val profileImage: ImageView = itemView.findViewById(R.id.profile_image)

        fun bind(item: ChatListItem.ChatMessage, onClick: (ChatListItem.ChatMessage) -> Unit) {
            userName.text = item.userName
            message.text = item.message
            time.text = item.time

            if (item.unreadCount > 0) {
                unreadBadge.visibility = View.VISIBLE
                unreadBadge.text = item.unreadCount.toString()
            } else {
                unreadBadge.visibility = View.GONE
            }

            if (!item.profileImageUrl.isNullOrEmpty()) {
                Glide.with(profileImage.context)
                    .load(item.profileImageUrl)
                    .placeholder(R.drawable.temp_pandit_new)
                    .into(profileImage)
            }

            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }

}
