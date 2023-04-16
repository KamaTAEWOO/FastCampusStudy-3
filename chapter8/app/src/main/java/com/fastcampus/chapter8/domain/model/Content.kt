package com.fastcampus.chapter8.domain.model

import java.util.*

data class Content(
    val id: Int? = null,
    val title: String,
    val content: String,
    val category: String,
    val createdDate: Date = Date(),
    val likeCount: Int? = null,
    val commentCount: Int? = null,
    val viewCount: Int? = null,
): java.io.Serializable
