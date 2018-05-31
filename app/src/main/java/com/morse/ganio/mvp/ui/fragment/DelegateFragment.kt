package com.morse.ganio.mvp.ui.fragment

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