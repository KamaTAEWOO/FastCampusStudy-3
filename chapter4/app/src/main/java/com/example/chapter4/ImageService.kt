package com.example.chapter4

import com.example.chapter4.mvc.ImageResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Authorization: Client-ID epJv3wchGygJU2HUfyrZ5l91vBWhodo3hfyFzMYQBdk")
    @GET("random")
    fun getRandomImage(): Call<ImageResponse>

    // RxJava 이용
    @Headers("Authorization: Client-ID epJv3wchGygJU2HUfyrZ5l91vBWhodo3hfyFzMYQBdk")
    @GET("random")
    fun getRandomImageRx(): Single<ImageResponse>

    @Headers("Authorization: Client-ID epJv3wchGygJU2HUfyrZ5l91vBWhodo3hfyFzMYQBdk")
    @GET("random")
    suspend fun getRandomImageSuspend(): ImageResponse
}