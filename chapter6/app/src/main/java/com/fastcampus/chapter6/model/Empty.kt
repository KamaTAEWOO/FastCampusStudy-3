package com.fastcampus.chapter6.model

class Empty : ListItem {
    override val viewType: ViewType
        get() = ViewType.EMPTY
}