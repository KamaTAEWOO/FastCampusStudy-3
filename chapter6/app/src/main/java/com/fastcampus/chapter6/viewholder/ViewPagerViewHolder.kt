package com.fastcampus.chapter6.viewholder

import com.fastcampus.chapter6.ListAdapter
import com.fastcampus.chapter6.databinding.ItemViewpagerBinding
import com.fastcampus.chapter6.model.ListItem
import com.fastcampus.chapter6.model.ViewPager

class ViewPagerViewHolder(
    binding: ItemViewpagerBinding
): BindingViewHolder<ItemViewpagerBinding>(binding) {

    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items)
    }
}