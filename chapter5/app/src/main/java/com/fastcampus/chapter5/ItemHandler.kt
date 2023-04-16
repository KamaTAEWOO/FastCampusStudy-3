package com.fastcampus.chapter5

import com.fastcampus.chapter5.model.ListItem

interface ItemHandler {

    fun onClickFavorite(item: ListItem)
}