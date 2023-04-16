package com.fastcampus.chapter5.repository

import com.fastcampus.chapter5.model.ListItem
import io.reactivex.rxjava3.core.Observable

interface SearchRepository {

    fun search(query: String): Observable<List<ListItem>>
}