package com.example.deal_in_android.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deal_in_android.common.entity.Users
import com.example.deal_in_android.common.dao.UserDAO

@Database(entities = [Users::class], version = 1)
abstract class DealinDB : RoomDatabase() {
    abstract fun usersDao() : UserDAO
}