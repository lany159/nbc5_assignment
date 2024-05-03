package com.example.nbc6application.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetWorkClient {

    private const val KAKAO_BASE_URL = "https://dapi.kakao.com/"
    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        //buildConfig = true
        //build > clean Project / Rebuild Project
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    private val kakaoRetrofit = Retrofit.Builder()
        .baseUrl(KAKAO_BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
            createOkHttpClient()
        ).build()

    val kakaoNetWork: NetWorkApi = kakaoRetrofit.create(NetWorkApi::class.java)
}