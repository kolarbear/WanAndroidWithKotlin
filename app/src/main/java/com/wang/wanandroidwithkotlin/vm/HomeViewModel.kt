package com.wang.wanandroidwithkotlin.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Koala on 2020/7/8.
 *
 * Description:
 */
class HomeViewModel(val list: MutableLiveData<List<Article>>) : ViewModel()