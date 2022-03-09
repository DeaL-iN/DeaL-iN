package com.example.deal_in_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deal_in_android.R
import com.example.deal_in_android.common.DealinDB

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(mainIntent)
        overridePendingTransition(0, 0)

//        var dealinDB = Room.databaseBuilder(
//            applicationContext,
//            DealinDB::class.java, "dealinDB"
//        ).build()

        //checkLogin(dealinDB)
    }

    // 자동로그인 여부 체크
    /**
    private fun checkLogin(db:DealinDB) {
        val usersDao = db.usersDao()
        val userInfo = usersDao.getUserInfo()
        // 자동로그인이 돼있음
        if (userInfo != null && userInfo.autoLogin){
            // 계정 정보가 있는지 확인
            val productListIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(productListIntent)
        }else{
            val loginIntent = Intent(this@SplashActivity, MainActivity::class.java).apply{
                putExtra("isLogin", true)
            }
            if (userInfo == null){
                startActivity(loginIntent)
                overridePendingTransition(0, 0)
            }else {
                loginIntent.putExtra("loginEmail", userInfo.email)
                loginIntent.putExtra("loginPwd", userInfo.password)
                startActivity(loginIntent)
                overridePendingTransition(0, 0)
            }
        }
    }
    */

}