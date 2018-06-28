package com.morse.ganio.main

import com.morse.ganio.mvp.BasePresenter

class MainPresenter : BasePresenter<IMain> {

    private var model: IMainModel? = null

    constructor() {
        model = MainModel()
    }

    fun getMain() {
        model!!.getMain()
    }

}