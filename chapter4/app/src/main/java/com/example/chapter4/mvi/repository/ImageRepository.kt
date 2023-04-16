package com.example.chapter4.mvi.repository

import com.example.chapter4.mvi.model.Image


interface ImageRepository {

    suspend fun getRandomImage() : Image
}