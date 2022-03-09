package com.example.deal_in_android.common.dao

import androidx.room.*
import com.example.deal_in_android.common.entity.Users

@Dao
interface UserDAO {
    // User 자동로그인 여부 확인
    @Query("SELECT autoLogin FROM users LIMIT 0, 1")
    fun checkAutoLogin(): Boolean

    // User 정보 전부 가져오기
    // User Email, Password 가져오기
    @Query("SELECT * FROM users LIMIT 0, 1")
    fun getUserInfo(): Users?



}