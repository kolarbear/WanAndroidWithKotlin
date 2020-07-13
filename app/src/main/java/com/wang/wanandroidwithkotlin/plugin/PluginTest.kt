package com.wang.wanandroidwithkotlin.plugin

/**
 * Created by Koala on 2020/7/11.
 *
 * Description: Kotlin 扩展函数
 */
fun String.suffix() = this+"suffix"

var String.customLength :Int
    get() = length-1
    set(value) {
        println(this.plus(value))}

fun isLeapYear(year: Int): Boolean{

    val listOf = listOf("as")
    for ((index,value) in listOf.withIndex())
    {
        println("index is $index and value is $value")
    }



    (1..10).forEach { println(it) }

    return year%4==0
}

fun nullableStrTest(){
    val nullableStr : String? = null
    println(nullableStr)
}

object Person{
    val name = "admin"
}
