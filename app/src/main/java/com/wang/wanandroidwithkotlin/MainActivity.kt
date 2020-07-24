package com.wang.wanandroidwithkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.wang.wanandroidwithkotlin.databinding.ActivityMainBinding
import com.wang.wanandroidwithkotlin.event.TestMessageEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        EventBus.getDefault().register(this)
    }


    @Subscribe
    fun test2(test: TestMessageEvent){
        Log.e(TAG,"This is just a test2")
    }

    @Subscribe(priority = 2)
    fun testMessageEvent(test: TestMessageEvent){
        Log.e(TAG,"This is just a test")
    }





    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }


}
