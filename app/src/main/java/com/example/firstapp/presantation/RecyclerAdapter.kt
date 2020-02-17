package com.example.firstapp.presantation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.domain.Notes

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>(){
    private var listnotes: List<Notes> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.text_view.text = listnotes[position].text
    }
    override fun getItemCount(): Int = listnotes.size

    fun setNotes(notes: List<Notes>) {
        this.listnotes = notes
        notifyDataSetChanged()
    }
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text_view: TextView = itemView.findViewById(R.id.rv_text)
    }
}