package com.fastcampus.chapter5.list.viewhoder

import androidx.recyclerview.widget.RecyclerView
import com.fastcampus.chapter5.ItemHandler
import com.fastcampus.chapter5.databinding.ItemVideoBinding
import com.fastcampus.chapter5.model.ListItem
import com.fastcampus.chapter5.model.VideoItem

class VideoViewHolder(
    private val binding: ItemVideoBinding,
    private val itemHandler: ItemHandler? = null
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
        binding.handler = itemHandler
    }
}