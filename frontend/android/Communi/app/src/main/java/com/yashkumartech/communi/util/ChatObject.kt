package com.yashkumartech.communi.util

data class ChatObject(
    val sender: String = "",
    val content: String = "",
    val timeSent: String = "hh:mm",
    val dateSent: String = "dd/mm/yyyy"
)