package com.fastcampus.chapter6.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fastcampus.chapter6.model.ListItem

class MainPagingSource(private val mainService: MainService)
    : PagingSource<Int, ListItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListItem> {
        return try {
            val page = params.key ?: 1
            val size = params.loadSize
            val result = mainService.getList(page, size).data
            LoadResult.Page(
                data = result.list,
                prevKey = null,
                nextKey = result.page.nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ListItem>): Int {
        return 0
    }
}