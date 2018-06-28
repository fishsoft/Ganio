package com.morse.ganio.http.utils

import com.morse.ganio.GanApp

class AppUtils {

    companion object {
        fun getContext() = GanApp.getApp()
    }
}