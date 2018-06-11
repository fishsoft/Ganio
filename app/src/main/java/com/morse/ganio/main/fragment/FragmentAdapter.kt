package com.morse.ganio.main.fragment

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlin.properties.Delegates

class FragmentAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<String> by Delegates.notNull()

    companion object {
        val NORMAL_TYPE = 0
        val IMAGE_TYPE = 1
    }

    init {
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            NORMAL_TYPE -> {
                return NormalItem(null)
            }
            IMAGE_TYPE -> {
                return ImageItem(null)
            }
            else -> return null!!
        }
    }

    override fun getItemCount(): Int {
        return this!!.items!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NormalItem) {
            //普通文本博客

        } else if (holder is ImageItem) {
            //妹子图集
        }
    }

    fun addItems(items: List<String>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class NormalItem(view: View?) : RecyclerView.ViewHolder(view) {
        fun bindData() {

        }
    }

    class ImageItem(view: View?) : RecyclerView.ViewHolder(view) {
        fun bindImage() {

        }
    }
}