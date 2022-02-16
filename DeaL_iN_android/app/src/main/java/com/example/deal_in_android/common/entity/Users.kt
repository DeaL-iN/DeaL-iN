package com.example.deal_in_android.common.entity

// 회원가입이나 로그인시에 활용되고 그 외에는 토큰사용예정
data class Users (
    // 이메일
    var email: String? = null,
    // 비밀번호: 회원가입시에만 사용될듯?
    var password: String? = null,
    // 이름
    var name: String? = null,
    // 닉네임
    var nickname: String? = null,
    // 연락처
    var tel: String? = null,
    // 주소
    var address: String? = null,
    // 상세주소
    var addressDetail: String? = null,
    // 보유 포인트
    var point: Int = 0,
    // 등급
    var grade: String? = null,
    // 프로필 사진
    var profileImageUrl:String? = null
)