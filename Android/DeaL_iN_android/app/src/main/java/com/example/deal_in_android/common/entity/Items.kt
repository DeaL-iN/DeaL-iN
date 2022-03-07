package com.example.deal_in_android.common.entity

import java.sql.Time
import kotlin.collections.ArrayList

data class Items(
    // 상품명
    var name:String? = null,
    // 카테고리 ID
    var categoryId:Int = 0,
    // 판매자 ID
    var sellerId:Int = 0,
    // 시작 가격
    var startPrice:Int = 0,
    // 판매 가격
    var sellPrice:Int = 0,
    // 착불/포함
    var status:Int? = null,
    // 마감 날짜
    var deadlineDate:Time? = null,
    // 상품 설명
    var contents:String? = null,
    // 마감 여부
    var isClosed:Boolean? = null,
    // 작성 날짜
    var createdAt:String? = null,
    // 이미지 링크 배열
    var photos:ArrayList<String>? = null
)