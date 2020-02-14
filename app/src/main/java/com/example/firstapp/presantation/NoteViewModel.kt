package com.example.firstapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.domain.NoteRepository

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    private var allNotes = repository.getAllNotes()

    fun insert(note: Notes) {
        repository.insert(note)
    }

    fun getAllNotes(): LiveData<List<Notes>>? {
        return allNotes
    }
}
