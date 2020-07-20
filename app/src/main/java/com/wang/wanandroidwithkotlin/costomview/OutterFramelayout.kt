package com.wang.wanandroidwithkotlin.costomview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * Created by Koala on 2020/7/20.
 *
 * Description:
 */
class OuterFrameLayout(mContext: Context,attributeSet: AttributeSet?) : FrameLayout(mContext,attributeSet) {


    val TAG = "OuterFrameLayout"



    constructor(mContext: Context): this(mContext,null)


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        var string = ""
        when (ev?.action) {
            MotionEvent.ACTION_DOWN ->
            {
                string = "down"
            }
            MotionEvent.ACTION_MOVE->
                string = "move"
            MotionEvent.ACTION_UP ->
                string = "up"
        }

        Log.e(TAG, "dispatchTouchEvent$string")

        return super.dispatchTouchEvent(ev)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        var string = ""
        when (ev?.action) {
            MotionEvent.ACTION_DOWN ->
                string = "down"
            MotionEvent.ACTION_MOVE->
                string = "move"
            MotionEvent.ACTION_UP ->
                string = "up"
        }

        Log.e(TAG, "onInterceptTouchEvent$string")
        return super.onInterceptTouchEvent(ev)
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

        Log.e(TAG, "onTouchEvent$string")

        return super.onTouchEvent(event)
    }


}