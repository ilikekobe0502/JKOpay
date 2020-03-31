package com.jkopay.homework.repository.data

import java.io.Serializable

data class Messages(
        var messages: ArrayList<MessageContent>?
) : Serializable

data class MessageContent(
        var id: Int?,
        var name: String?,
        var message: String?,
        var time: String?
) : Serializable