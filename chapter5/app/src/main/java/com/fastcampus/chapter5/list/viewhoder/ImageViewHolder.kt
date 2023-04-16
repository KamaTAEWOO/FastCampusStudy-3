package com.fastcampus.chapter5.list.viewhoder

import androidx.recyclerview.widget.RecyclerView
import com.fastcampus.chapter5.ItemHandler
import com.fastcampus.chapter5.databinding.ItemImageBinding
import com.fastcampus.chapter5.model.ImageItem
import com.fastcampus.chapter5.model.ListItem

class ImageViewHolder(
    private val binding: ItemImageBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root){
    
    fun bind(item: ListItem) {
        item as ImageItem
        binding.item = item
        binding.handler = itemHandler
    }
}