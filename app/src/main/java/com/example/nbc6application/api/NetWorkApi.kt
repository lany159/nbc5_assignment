package com.example.nbc6application.api

import com.example.nbc6application.data.KakaoData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetWorkApi{
    @Headers("Authorization: KakaoAK 5483106a78a1304721ea242a461b6575")
    @GET("v2/search/image")

    suspend fun getKakao(
        @Query("query") query:String,
        @Query("size") size:Int
    ) : KakaoData
}