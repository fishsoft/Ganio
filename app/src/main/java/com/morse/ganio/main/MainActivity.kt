package com.morse.ganio.main

import android.os.Bundle
import android.view.View
import com.morse.ganio.R
import com.morse.ganio.mvp.ui.activity.MVPActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MVPActivity<IMain, MainPresenter>(), IMain {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                getPresenter().getMain()
            }

        })
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }
}
