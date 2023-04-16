package com.example.chapter4.mvi.model

sealed class MviIntent {
    object LoadImage : MviIntent()
}