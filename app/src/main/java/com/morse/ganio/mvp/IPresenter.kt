package com.morse.ganio.mvp

/**
 * Presenter接口
 */
interface IPresenter<V : IView> {

    /**
     * 绑定视图
     */
    fun attachView(v: V?)

    /**
     * 解绑视图
     */
    fun dettechView()
}