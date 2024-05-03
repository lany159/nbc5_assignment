package com.example.nbc6application.api

import com.example.nbc6application.data.KakaoData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetWorkApi{
    @Headers("Authorization: KakaoAK 5483106a78a1304721ea242a461b6575")
    @GET("v2/search/image")

    suspend fun getKakao(
        //@Query("param1") param1 : String? = null
        @Query("query") query:String
//        @Query("sort") sort:String,
//        @Query("page") page:Int,
//        @Query("size") size:String
    //필수가 아닌 것들은 작성하지 않아도 되는 것?
        //작성하되 @Query("size") size:String? = null ?
    ) : KakaoData
}
//요청값