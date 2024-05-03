package com.example.nbc6application.data

import java.util.Date

data class Documents(
    val collection : String,
    val thumbnail_url : String,
    val image_url : String,
    val width : Int,
    val height : Int,
    val display_sitename : String,
    val doc_url : String,
    val datetime : Date
    //val datetime : Date
    //변수명이 하나라도 틀리면 안된다고 하는데, 그렇다면 저 변수명을 그대로 사용해도 되는 것?
)
