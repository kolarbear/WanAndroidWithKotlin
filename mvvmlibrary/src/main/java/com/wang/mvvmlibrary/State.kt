package com.wang.mvvmlibrary

import com.wang.mvvmlibrary.state.StateType

/**
 * author：kolarbear
 * create time：2020年7月17日, 0017 17:05
 */
 data class State(var code: StateType, var msg : String = "", var tip : Int = 0)