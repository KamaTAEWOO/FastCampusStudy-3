package com.fastcampus.chapter8.data.model.dto

import java.util.Date

data class ContentDto(
    val id:Int? = null,
    val title:String,
    val content:String,
    val category:String,
    val createdDate: Date? = null,
    val likeCount: Int? = null,
    val commentCount: Int? = null,
    val viewCount: Int? = null,
)
