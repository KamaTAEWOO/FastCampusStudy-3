package com.example.chapter4.mvvm.repository

import com.example.chapter4.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {

    // Single : RxJava에서 제공하는 Observable 클래스
    // 오직 하나의 아이템만 방출하는 Observable == SingleTon(하나의 객체를 생성해서 다른 객체를 생성하지 못하게 하는 것)이랑 비슷한 개념
    fun getRandomImage() : Single<Image>
}