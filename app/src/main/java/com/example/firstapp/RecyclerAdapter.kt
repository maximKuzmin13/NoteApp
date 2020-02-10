package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>(){
    private var notes :  MutableList<Notes> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(itemView)

    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model = notes[position]
        holder.text_view.text = model.text
    }
    override fun getItemCount() = notes.size


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val text_view: TextView = itemView.rv_text
    }

}