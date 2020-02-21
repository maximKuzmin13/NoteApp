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
        holder.textView.text = listnotes[position].text
        holder.titleText.text = listnotes[position].title
        holder.dateNote.text = listnotes[position].noteDate
    }
    override fun getItemCount(): Int = listnotes.size

    fun setNotes(notes: List<Notes>) {
        this.listnotes = notes
        notifyDataSetChanged()
    }
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.rv_text)
        val titleText: TextView = itemView.findViewById(R.id.title_note)
        val dateNote: TextView = itemView.findViewById(R.id.date)

    }
}