package com.example.chapter4

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    // okHttp 설정
    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .build()

    // gson : Json 객체를 직렬화(바이트 객체로 변환) 또는 역직렬화(바이트를 복원) 가능
    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.unsplash.com/photos/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Rx를 받아오기 위해 사용. -> 스레드를 비동기로 처리
        .client(okHttpClient)
        .build()

    // 실제 사용할 이미지 서비스
    // lazy : 실행 후 처음으로 imageService에 접근할 때 초기화가 이루어짐.
    val imageService: ImageService by lazy { retrofit.create(ImageService::class.java) }
}