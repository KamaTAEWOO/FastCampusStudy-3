package com.fastcampus.chapter6

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.fastcampus.chapter6.model.ListItem

class DiffCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.viewType == newItem.viewType && oldItem.getKey() == newItem.getKey()


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem

}