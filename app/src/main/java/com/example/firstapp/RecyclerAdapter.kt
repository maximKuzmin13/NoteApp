package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>(){
    private var notes = mutableListOf<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false))
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model:Notes = notes[position]
        holder.TextatNote.text = model.text
    }
    override fun getItemCount() = notes.size

    fun setNotes(newnote: List<Notes>) {
        this.notes = newnote as MutableList<Notes>
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val TextatNote: TextView = itemView.findViewById(R.id.rv_text)
    }
}