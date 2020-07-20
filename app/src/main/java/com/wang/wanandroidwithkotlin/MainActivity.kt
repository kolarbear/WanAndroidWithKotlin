package com.wang.wanandroidwithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.wang.wanandroidwithkotlin.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil.setContentView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        isOdd(3)

        initTouchEvent()
        val listOf = listOf(1, 2, 3)
        listOf.filter(::isOdd)
    }

    fun initTouchEvent(){



       /* touch_event.setOnTouchListener(fun(_: View, motionEvent: MotionEvent): Boolean {
            var string = ""
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN ->
                    string = "down"
                MotionEvent.ACTION_MOVE->
                    string = "move"
                MotionEvent.ACTION_UP ->
                    string = "up"
            }

            Log.e("TextView", "setOnTouchListener$string")
            return true
        })*/

        touch_event.setOnClickListener { Log.e("MainActivity","click") }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        var string = ""
        when (event?.action) {
            MotionEvent.ACTION_DOWN ->
                string = "down"
            MotionEvent.ACTION_MOVE->
                string = "move"
            MotionEvent.ACTION_UP ->
                string = "up"
        }

        Log.e("MainActivity", "onTouchEvent$string")

        return super.onTouchEvent(event)
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        var string = ""
        when (ev?.action) {
            MotionEvent.ACTION_DOWN ->
                string = "down"
            MotionEvent.ACTION_MOVE->
                string = "move"
            MotionEvent.ACTION_UP ->
                string = "up"
        }

        Log.e("MainActivity", "dispatchTouchEvent$string")


        return super.dispatchTouchEvent(ev)
    }

    fun isOdd(x:Int) = x%2!=0

}
