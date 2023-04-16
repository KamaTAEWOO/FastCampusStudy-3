package com.fastcampus.chapter7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fastcampus.chapter7.model.ContentEntity
import com.fastcampus.chapter7.repository.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentRepository: ContentRepository
) : ViewModel() {

    val contentList = contentRepository.loadList()
        .stateIn(
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope
        )

    fun updateItem(item: ContentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            contentRepository.modify(item)
        }
    }

    fun deleteItem(item: ContentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            contentRepository.delete(item)
        }
    }
}