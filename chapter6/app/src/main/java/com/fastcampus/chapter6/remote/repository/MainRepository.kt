package com.fastcampus.chapter6.remote.repository

import androidx.paging.PagingData
import com.fastcampus.chapter6.model.ListItem
import kotlinx.coroutines.flow.Flow


interface MainRepository {

    fun loadList() : Flow<PagingData<ListItem>>
}