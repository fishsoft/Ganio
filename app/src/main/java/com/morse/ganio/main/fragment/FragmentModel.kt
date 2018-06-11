package com.morse.ganio.main.fragment

import android.util.Log

class FragmentModel : IFragmentModel {
    override fun getFragmentInfo(type: Int) {
        Log.d("morse", "FragmentModel getFragmentInfo type :$type")
    }
}