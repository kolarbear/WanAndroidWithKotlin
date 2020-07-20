package com.wang.wanandroidwithkotlin.costomview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.core.view.marginTop
import kotlin.math.abs

/**
 * Created by Koala on 2020/7/20.
 *
 * Description:
 */
class InnerTextView(mContext:Context,attributeSet: AttributeSet):androidx.appcompat.widget.AppCompatTextView(mContext,attributeSet) {


    private val TAG =  "InnerTextView"
    var topMargin :Int = 0
    var downY :Float = 0f
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {



        var string = ""

        when (event?.action) {
            MotionEvent.ACTION_DOWN ->
            {
                string = "down"
                downY = event.rawY
                topMargin = (layoutParams as FrameLayout.LayoutParams).topMargin
            }
            MotionEvent.ACTION_MOVE->{
                string = "move"
                if (abs(event.rawY-downY) >5)
                {
                    val f1 = event.rawY - downY
                    (layoutParams as FrameLayout.LayoutParams).setMargins(0,
                        (topMargin +f1).toInt(),0,0)
                }
                requestLayout()
            }
            MotionEvent.ACTION_UP ->
                string = "up"
        }

        Log.e(TAG, "dispatchTouchEvent$string")


        return false
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {


        var string = ""
        when (event?.action) {
            MotionEvent.ACTION_DOWN ->
            {
                string = "down"
            }
            MotionEvent.ACTION_MOVE->
                string = "move"
            MotionEvent.ACTION_UP ->
                string = "up"
        }

        Log.e(TAG, "onTouchEvent$string")

        return super.onTouchEvent(event)
    }

}