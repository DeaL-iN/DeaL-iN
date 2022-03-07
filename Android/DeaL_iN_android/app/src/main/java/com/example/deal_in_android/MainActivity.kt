package com.example.deal_in_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.deal_in_android.R
import com.example.deal_in_android.chat.ChatListFragment
import com.example.deal_in_android.mypage.MyPageFragment
import com.example.deal_in_android.mypage.users.LoginFragment
import com.example.deal_in_android.post.PostFragment
import com.example.deal_in_android.product.ProductListFragment
import com.example.deal_in_android.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Bottom Navigation에서 활용될 5개 Fragment 우선 설정
    private val productListFragment = ProductListFragment()
    private val searchFragment = SearchFragment()
    private val postFragment = PostFragment()
    private val chatListFragment = ChatListFragment()
    private val myPageFragment = MyPageFragment()
    private val loginFragment = LoginFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBottomNavigation()

        // 기본 화면 = 상품 목록
        changeFragment(productListFragment)
    }

    private fun setBottomNavigation(){
        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    changeFragment(productListFragment)
                }
                R.id.search -> {
                    changeFragment(searchFragment)
                }
                R.id.post -> {
                    changeFragment(postFragment)
                }
                R.id.chat -> {
                    changeFragment(chatListFragment)
                }
                R.id.mypage -> {
                    // 로그인이 안돼있으면 로그인페이지로
                    if(true){
                        changeFragment(loginFragment)
                    }else{
                        changeFragment(myPageFragment)
                    }
                }
            }
            true
        }

    }

    public fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }


}