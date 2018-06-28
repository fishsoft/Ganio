package com.morse.ganio.main.fragment

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.morse.ganio.R
import com.morse.ganio.entries.GrilResult
import kotlinx.android.synthetic.main.item_normal.view.*
import kotlin.properties.Delegates

class FragmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<GrilResult> by Delegates.notNull()

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
                return NormalItem(LayoutInflater.from(parent.context)!!.inflate(R.layout.item_normal, parent, false))
            }
            IMAGE_TYPE -> {
                return ImageItem(null)
            }
            else -> return null!!
        }
    }

    override fun getItemCount(): Int {
        return this?.items?.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NormalItem) {
            //普通文本博客
            holder.bindData("", items[position])
        } else if (holder is ImageItem) {
            //妹子图集
            holder.bindImage()
        }
    }

    fun addItems(items: List<GrilResult>?) {
        items?.let { this.items.addAll(it) }
        notifyDataSetChanged()
    }

    class NormalItem(view: View?) : RecyclerView.ViewHolder(view) {
        fun bindData(type: String, result: GrilResult) {
            with(result) {
                itemView.iv_item_normal.setImageURI(Uri.parse(url))
                itemView.tv_item_author.text = who
                itemView.tv_item_time.text = publishedAt
                itemView.tv_item_title.text = desc
            }
        }
    }

    class ImageItem(view: View?) : RecyclerView.ViewHolder(view) {
        fun bindImage() {

        }
    }
}