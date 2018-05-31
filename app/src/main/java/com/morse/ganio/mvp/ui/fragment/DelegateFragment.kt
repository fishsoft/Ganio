package com.morse.ganio.mvp.ui.fragment

/**
 * 代理fragment生命周期
 */
interface DelegateFragment {

    /**
     * 创建是Fragment
     */
    fun onCreateView()

    /**
     * 视图Fragment
     */
    fun onDestroy()

}