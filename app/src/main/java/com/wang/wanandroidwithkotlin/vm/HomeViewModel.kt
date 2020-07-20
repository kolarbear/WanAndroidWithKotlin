package com.wang.wanandroidwithkotlin.vm

import androidx.lifecycle.MutableLiveData
import com.wang.mvvmlibrary.base.BaseViewModel
import com.wang.wanandroidwithkotlin.repository.HomeRepository

/**
 * Created by Koala on 2020/7/8.
 *
 * Description:
 */
class HomeViewModel : BaseViewModel<HomeRepository>(){

    val list: MutableLiveData<List<Article>> = MutableLiveData()

}