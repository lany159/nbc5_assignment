package com.example.nbc6application.data

//data class Kakao(val response : KakaoData)

data class KakaoData(
    val documents: List<Documents>,
    //val documents: List<Any>
    val meta: Meta
)