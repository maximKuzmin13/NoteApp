package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>(){
    var value = ArrayList<String>()

    fun setValue(number:List<String>){
        value.clear()
        value.addAll(number)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.numbers.text = value[position]
    }
    override fun getItemCount() = value.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numbers: TextView = itemView.rv_text
    }
}