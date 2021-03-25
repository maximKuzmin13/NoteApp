package com.example.testapp.presantation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.FakeNotes
import com.example.testapp.domain.Notes

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    private var listnotes: List<Notes> = ArrayList()
    private var listFakenotes: List<FakeNotes> = ArrayList()

    private var listener: NoteClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {


        if (listFakenotes.isNullOrEmpty()) {
            val note: Notes = getNote(position)
            holder.textView.text = note.text
            holder.titleText.text = note.title
            holder.itemView.setOnClickListener { listener?.onNoteClick(note) }
        } else {

            val fakeNotes: FakeNotes = getFakeNote(position)
            holder.textView.text = fakeNotes.text
            holder.titleText.text = fakeNotes.title
        }
    }


    override fun getItemCount(): Int = listnotes.size + listFakenotes.size

    fun getNote(position: Int): Notes {
        return listnotes[position]
    }

    fun getFakeNote(position: Int): FakeNotes {
        return listFakenotes[position]
    }

    fun setListener(listener: NoteClickListener?) {
        this.listener = listener
    }

    fun setNotes(notes: List<Notes>) {
        this.listnotes = notes
        notifyDataSetChanged()
    }

    fun setFakeNotes(notes: List<FakeNotes>) {
        this.listFakenotes = notes
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.rv_text)
        val titleText: TextView = itemView.findViewById(R.id.title_note)
    }
}