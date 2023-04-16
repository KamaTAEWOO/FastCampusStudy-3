package com.example.chapter4.mvp.repository
 interface ImageRepository {

     // ImageRepositoryImpl에서 구현
    fun getRandomImage(callBack: CallBack)

    interface CallBack {
        fun loadImage(url: String, color: String)
    }

}