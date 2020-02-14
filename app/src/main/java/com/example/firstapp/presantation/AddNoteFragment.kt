package com.example.firstapp.presantation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.domain.Notes
import com.example.firstapp.R
import kotlinx.android.synthetic.main.fragment_text.*

class AddNoteFragment: Fragment(){
    val textList = ArrayList<Notes>()
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        noteViewModel = ViewModelProvider(this@AddNoteFragment).get(NoteViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Новая заметка"
        return inflater.inflate(R.layout.fragment_text, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savebtn.setOnClickListener{
            saveNote()
            (activity as AppCompatActivity).supportActionBar?.title = "Заметки"
            activity?.supportFragmentManager?.popBackStack()
        }
    }
    private fun saveNote() {
        val data = text_note.text.toString()
        val input = Notes(data)
        textList.add(input)
        RecyclerAdapter().setNotes(textList)
    }
}