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
import com.example.firstapp.data.NoteInteratorImpl
import com.example.firstapp.data.NoteRepositoryImpl
import com.example.firstapp.domain.NoteInterator
import kotlinx.android.synthetic.main.fragment_text.*
import org.koin.android.ext.android.inject

class AddNoteFragment: Fragment(){
    val noteInteractor: NoteInteratorImpl by inject()
    val noteViewModel: NoteViewModel by inject()
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
            val data = text_note.text.toString()
            noteViewModel.insert(Notes(data))
            (activity as AppCompatActivity).supportActionBar?.title = "Заметки"
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}