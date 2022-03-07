package com.example.deal_in_android.common.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 회원가입이나 로그인시에 활용되고 그 외에는 토큰사용예정
// 임시로 DB화
@Entity
data class Users (
    // ID
    @PrimaryKey val userId: Int,
    // 이메일
    @ColumnInfo(name = "email") var email: String? = null,
    // 비밀번호: 회원가입시에만 사용될듯?
    @ColumnInfo(name = "password")var password: String? = null,
    // 이름
    @ColumnInfo(name = "name") var name: String? = null,
    // 닉네임
    @ColumnInfo(name = "nickname") var nickname: String? = null,
    // 연락처
    @ColumnInfo(name = "tel") var tel: String? = null,
    // 주소
    @ColumnInfo(name = "address") var address: String? = null,
    // 상세주소
    @ColumnInfo(name = "addressDetail") var addressDetail: String? = null,
    // 보유 포인트
    @ColumnInfo(name = "point") var point: Int = 0,
    // 등급
    @ColumnInfo(name = "grade") var grade: String? = null,
    // 프로필 사진
    @ColumnInfo(name = "profileImageUrl") var profileImageUrl:String? = null,
    // 자동로그인 여부
    @ColumnInfo(name = "autoLogin") var autoLogin: Boolean = true
)