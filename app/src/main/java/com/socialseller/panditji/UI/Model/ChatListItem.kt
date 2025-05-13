package com.socialseller.panditji.UI.Model

sealed class ChatListItem {
    data class ChatMessage(
        val userName: String,
        val message: String,
        val time: String,
        val unreadCount: Int,
        val profileImageUrl: String? = null // Optional
    ) : ChatListItem()

    data class DateHeader(val dateLabel: String) : ChatListItem()
}

