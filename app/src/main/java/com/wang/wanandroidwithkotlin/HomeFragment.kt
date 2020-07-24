package com.wang.wanandroidwithkotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider


import androidx.navigation.fragment.findNavController

import com.wang.wanandroidwithkotlin.adapter.HomeAdapter
import com.wang.wanandroidwithkotlin.databinding.FragmentHomeBinding
import com.wang.wanandroidwithkotlin.event.TestMessageEvent

import com.wang.wanandroidwithkotlin.plugin.suffix
import com.wang.wanandroidwithkotlin.vm.Article
import com.wang.wanandroidwithkotlin.vm.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.EventBus

/**
 * Created by Koala on 2020/7/8.
 *
 * Description:首页显示的样式
 */
typealias G = (String)-> Int
typealias F = (Int) -> Boolean
typealias H = (String) -> Boolean
class HomeFragment : Fragment() {

    lateinit var vm:HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        val articleList = listOf(Article("钢铁，病菌与枪炮"), Article("寂寞的游戏"))

        vm = ViewModelProvider(this).get(HomeViewModel::class.java)

        vm.list.value = articleList

        binding.vm = vm

        vm.list.observe(viewLifecycleOwner, Observer {
            binding.adapter?.submitList(it)
        })

//        testAlsoFun()

        binding.loginState = true

        binding.clickProxy = ClickProxy(this)
        val homeAdapter = HomeAdapter(requireContext())

        binding.adapter = homeAdapter

        return binding.root
    }





    inner class ClickProxy(val fragment: HomeFragment){


        fun jumpToLogin()
        {

            val action =
                HomeFragmentDirections.actionHomeFragmentToLoginFragment()

            val well = "well done"

            Log.e("HomeFragment","login?${well.suffix()}")


            fragment.findNavController().navigate(action)
        }

        fun changeLiveData(){
            vm.list.value = listOf(Article("追风筝的人"), Article("爱你就像爱生命"))
            EventBus.getDefault().post(TestMessageEvent())
        }
    }


    val f = fun (x:Int) = x%2 == 1
    val g = fun (s:String) = s.length
    val h = fun (g: G, f :F): H{
        return  { f(g(it)) }
    }

    fun testHighFun()
    {
        val list = listOf("a","ab","abc","abcd","abcde","abcdef","abcdefg")
        println(list.filter ( h(g,f) ))
    }

    fun testAlsoFun()
    {
        val a = "ABC"

//        a.also { println("also$it") }
//        println(a)
//        a.let {
//            println("let$it")
//        }.also {
//            println(it)
//        }
//        println(a.run {
//            println("run$this")
//        })
//        println(
//            a.apply {
//
//            println("apply$this")
//        })
//
//        println(
//            a.let {
//            println("let$it")
//        })
//
//        println(
//            a.also {
//                println("also$it")
//            })
        with(ArrayList<String>()){
            add("1")
            add("2")
            add("3")
//            println("with$this")
        }.let {

        }


    }

    //类型上界
    fun <T: Comparable<T>> gt(x:T,y:T):Boolean{
        return x>y
    }



    abstract class Shape

    class Circle: Shape()

    data class User(var name:String)

}