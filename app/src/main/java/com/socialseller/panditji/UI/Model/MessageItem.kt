package com.socialseller.panditji.UI.Model

sealed class MessageItem {
    data class SentMessage(val text: String, val time: String) : MessageItem()
    data class ReceivedMessage(val text: String, val time: String) : MessageItem()
}

