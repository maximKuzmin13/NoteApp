package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>(){
    private val note = ArrayList<String>()

    fun setValue(text:List<String>){
        note.clear()
        note.addAll(text)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.notes.text = note[position]
    }
    override fun getItemCount() = note.size

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notes: TextView = itemView.rv_text
    }
}