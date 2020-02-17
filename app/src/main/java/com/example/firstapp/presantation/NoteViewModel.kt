package com.example.firstapp.presantation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.Notes
import com.example.firstapp.domain.NoteRepository

class NoteViewModel(
    private val repository: NoteRepository
//    private val iterator: NoteInterator
) : ViewModel() {

    private var allNotes = repository.getAllNotes()

    fun insert(note: Notes) {
        repository.insert(note)
    }

    fun getAllNotes(): LiveData<List<Notes>>? {
        return allNotes
    }
}
