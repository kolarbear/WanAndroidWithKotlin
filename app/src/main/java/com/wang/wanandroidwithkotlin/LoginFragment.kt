package com.wang.wanandroidwithkotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wang.wanandroidwithkotlin.databinding.FragmentLoginBinding
import com.wang.wanandroidwithkotlin.vm.User

/**
 * author：kolarbear
 * create time：2020年7月9日, 0009 12:13
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.user = User(ObservableField("小麦"), ObservableField("123456"))
        binding.click = ClickProxy(this)

        return binding.root
    }


    inner class ClickProxy(private val fragment: LoginFragment){

         fun doLogin(user: User){

            val javaClass = user.javaClass

//           Log.e("ClickProxy",user.name)
            Toast.makeText(fragment.context,"${user.name.get()}登录成功~",Toast.LENGTH_SHORT).show()
            fragment.activity?.onBackPressed()
        }
    }
}