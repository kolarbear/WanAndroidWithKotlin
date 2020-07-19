package com.wang.mvvmlibrary.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * author：kolarbear
 * create time：2020年7月17日, 0017 14:13
 */
open class BaseRepository {

    private val mCompositeDisposable by lazy { CompositeDisposable() }

    fun addSubscribe(d:Disposable) = mCompositeDisposable.add(d)

    fun unSubscribe() = mCompositeDisposable.dispose()

}