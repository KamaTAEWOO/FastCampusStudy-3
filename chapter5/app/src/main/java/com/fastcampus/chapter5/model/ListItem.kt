package com.fastcampus.chapter5.model

import java.util.*

interface ListItem {
    val thumbnailUrl: String
    val dateTime: Date
    val isFavorite: Boolean
}