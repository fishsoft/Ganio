package com.morse.ganio.main.fragment

import com.morse.ganio.entries.Result
import com.morse.ganio.mvp.IView

interface IFragment : IView {

    fun onSuccess(results:List<Result>)

}