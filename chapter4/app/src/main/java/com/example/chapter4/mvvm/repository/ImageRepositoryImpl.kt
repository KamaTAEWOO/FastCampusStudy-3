package com.example.chapter4.mvvm.repository

import com.example.chapter4.RetrofitManager
import com.example.chapter4.mvvm.model.Image
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ImageRepositoryImpl: ImageRepository {

    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item ->
            Single.just(Image(item.urls.regular, item.color)) // Image Model에 맞춰서 넣어주는 코드
        }

}