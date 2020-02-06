package com.example.firstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>(){
    private var notes: List<Notes> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false))
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(notes[position])
    }
    override fun getItemCount() = notes.size

    fun setNotes(notes: List<Notes>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note:Notes) = with(itemView){
            rv_text.text = note.text
        }
    }
}