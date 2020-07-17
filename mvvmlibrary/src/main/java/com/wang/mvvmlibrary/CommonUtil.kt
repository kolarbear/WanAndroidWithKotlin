package com.wang.mvvmlibrary

import java.lang.reflect.ParameterizedType

/**
 * author：kolarbear
 * create time：2020年7月17日, 0017 16:41
 */
object CommonUtil {

    fun <T> getClass(t: Any): Class<T>{

        return (t.javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<T>
    }

}