package com.wang.wanandroidwithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wang.wanandroidwithkotlin.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil.setContentView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        isOdd(3)


        val listOf = listOf(1, 2, 3)
        listOf.filter(::isOdd)
    }

    fun isOdd(x:Int) = x%2!=0

}
