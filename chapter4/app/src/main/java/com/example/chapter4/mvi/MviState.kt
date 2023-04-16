package com.example.chapter4.mvi

import com.example.chapter4.mvi.model.Image

sealed class MviState {
    object Idle: MviState() // 초기값
    object Loading: MviState() // Repository에서 데이터를 들고 오고 있다면 Loading state로 빠짐.
    data class LoadedImage(val image: Image, val count: Int): MviState()
}
