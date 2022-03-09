package com.example.deal_in_android.mypage.users

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.deal_in_android.MainActivity
import com.example.deal_in_android.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 로그인 버튼
        loginButton.setOnClickListener {
            var userEmail = userEmailInput.text.toString()
            var userPwd = userPwdInput.text.toString()
            val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
            val regexResult = emailRegex.matchEntire(userEmail)?.value
            if (regexResult != null) {
                // 여기서 서버통신

            } else {
                Toast.makeText(activity, "이메일을 확인해주세요.", Toast.LENGTH_LONG)
            }
        }
        // 회원가입 버튼
        registerButton.setOnClickListener {
            val activity = MainActivity()
            val registerFragment = RegisterFragment()
            activity.changeFragment(registerFragment)
        }

        // 아이디 찾기
    }
}
