package com.fastcampus.chapter7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ContentView
import androidx.recyclerview.widget.DiffUtil
import com.fastcampus.chapter7.model.ContentEntity
import androidx.recyclerview.widget.ListAdapter
import com.fastcampus.chapter7.databinding.ItemContentBinding

class ListAdapter(private val handler: MainActivity.Handler) : ListAdapter<ContentEntity, ContentViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            handler
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object :DiffUtil.ItemCallback<ContentEntity>() {
            override fun areItemsTheSame(oldItem: ContentEntity, newItem: ContentEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}