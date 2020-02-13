package com.example.firstapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {
    private var repository: NoteRepository? = null
    private var allNotes: LiveData<List<Notes>>? = repository?.getAllNotes()

    fun insert(note: Notes) {
        repository?.insert(note)
    }

    fun getAllNotes(): LiveData<List<Notes>>? {
        return allNotes
    }
}
