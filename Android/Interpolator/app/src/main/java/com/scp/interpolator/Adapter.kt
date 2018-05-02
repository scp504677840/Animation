package com.scp.interpolator

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Interpolator
import android.widget.TextView

class Adapter(private val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    var items = ArrayList<Item>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_main, null, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        //设置类名
        setClassName(holder.classNameTV, item.className)

        //设置描述
        setDesc(holder.descTV, item.desc)

        //item点击事件
        holder.itemView.setOnClickListener { onItemClickListener?.onClick(item.interpolator) }

    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * 类名
         */
        val classNameTV: TextView = itemView.findViewById(R.id.item_main_class_name_tv)

        /**
         * 描述
         */
        val descTV: TextView = itemView.findViewById(R.id.item_main_desc_tv)
    }

    interface OnItemClickListener {
        fun onClick(interpolator: Interpolator)
    }

    var onItemClickListener: OnItemClickListener? = null

    /**
     * 设置类名
     *
     * @param classNameTV 类名TextView
     * @param className 类名
     */
    private fun setClassName(classNameTV: TextView, className: String) {
        classNameTV.text = className
    }

    /**
     * 设置描述
     *
     * @param descTV 描述TextView
     * @param desc 描述
     */
    private fun setDesc(descTV: TextView, desc: String) {
        descTV.text = desc
    }

}