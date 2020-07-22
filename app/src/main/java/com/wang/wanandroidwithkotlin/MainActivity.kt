package com.wang.wanandroidwithkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.wang.wanandroidwithkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        isOdd(3)

        initTouchEvent()
        val listOf = listOf(1, 2, 3)
        listOf.filter(::isOdd)
    }

    private fun initTouchEvent(){
        touch_event.setOnClickListener { Log.e("MainActivity","click")
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart")
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
            MotionEvent.ACTION_CANCEL ->
                string = "cancel"
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
            MotionEvent.ACTION_CANCEL ->
                string = "cancel"
        }

        Log.e("MainActivity", "dispatchTouchEvent$string")


        return super.dispatchTouchEvent(ev)
    }

    fun isOdd(x:Int) = x%2!=0

}
