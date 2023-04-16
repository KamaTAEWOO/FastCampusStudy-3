package com.fastcampus.chapter5

import com.fastcampus.chapter5.model.ImageListResponse
import com.fastcampus.chapter5.model.VideoListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {

    @Headers("Authorization: KakaoAK 0bf1c02a8b8e3968299fce8a2a046fee")
    @GET("image")
    fun searchImage(@Query("query") query: String): Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK 0bf1c02a8b8e3968299fce8a2a046fee")
    @GET("vclip")
    fun searchVideo(@Query("query") query: String): Observable<VideoListResponse>

}