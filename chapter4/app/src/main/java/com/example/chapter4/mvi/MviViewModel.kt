package com.example.chapter4.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.chapter4.mvi.model.MviIntent
import com.example.chapter4.mvi.repository.ImageRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MviViewModel(private val imageRepository: ImageRepository) : ViewModel() {

    val channel = Channel<MviIntent>() // Intent는 Channel로 받아야함.

    private val _state = MutableStateFlow<MviState>(MviState.Idle) // MutableStateFlow는 초기값이 반드시 필요함.
    val state: StateFlow<MviState> get() = _state

    private var count = 0

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            channel.consumeAsFlow().collectLatest {
                when(it) {
                    MviIntent.LoadImage -> {
                        loadImage()
                    }
                }
            }
        }
    }

    private fun loadImage() {
        viewModelScope.launch {
            _state.value = MviState.Loading
            val image = imageRepository.getRandomImage()
            count++
            _state.value = MviState.LoadedImage(image, count) //데이터를 모두 가지고 온 상태

        }
    }

    class MviViewModelFactory(private val imageRepository: ImageRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MviViewModel(imageRepository) as T
        }
    }
}