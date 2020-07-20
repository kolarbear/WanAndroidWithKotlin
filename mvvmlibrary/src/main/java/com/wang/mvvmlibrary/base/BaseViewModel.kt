package com.wang.mvvmlibrary.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wang.mvvmlibrary.CommonUtil
import com.wang.mvvmlibrary.State

/**
 * author：kolarbear
 * create time：2020年7月17日, 0017 14:08
 */
open class BaseViewModel<R : BaseRepository> : ViewModel() {

    val loadState by lazy { MutableLiveData<State>() }

    val mRepository: R by lazy {
        CommonUtil.getClass<R>(this)
            .getDeclaredConstructor(MutableLiveData::class.java)
            .newInstance()
    }


    override fun onCleared() {
        super.onCleared()
        mRepository.unSubscribe()
    }
}