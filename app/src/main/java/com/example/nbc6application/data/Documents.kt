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
    val datetime : Date,
    var isLike : Boolean
//    val isLike : Boolean
    //변수명 그대로 사용 가능 > 이름 변경 시 @SerializedName("") 이용
)
