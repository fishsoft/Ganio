package com.morse.ganio

import android.app.Application

class GanApp : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        private var app: Application? = null
        fun getApp() = this.app

    }
}