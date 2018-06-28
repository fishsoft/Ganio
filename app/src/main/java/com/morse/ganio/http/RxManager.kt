package com.morse.ganio.http;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Horrarndoo on 2017/9/12.
 * <p>
 * 用于管理Rxjava 注册订阅和取消订阅
 */

class RxManager {
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()// 管理订阅者者

    fun register(d: Disposable?) {
        d?.let {
            mCompositeDisposable.addAll(it)
        }
    }

    fun unSubscribe() {
        mCompositeDisposable.dispose()// 取消订阅
    }
}