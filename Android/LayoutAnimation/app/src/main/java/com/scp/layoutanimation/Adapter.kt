package com.scp.layoutanimation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Adapter(context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    var names = ArrayList<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_main, null, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = names[position]

        //设置名称
        setName(holder.nameTV, name)
    }

    override fun getItemCount(): Int = names.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV: TextView = itemView.findViewById(R.id.item_main_name_tv)
    }

    /**
     * 设置名称
     *
     * @param nameTV 名称TextView
     * @param name 名称
     */
    private fun setName(nameTV: TextView, name: String) {
        nameTV.text = name
    }

}