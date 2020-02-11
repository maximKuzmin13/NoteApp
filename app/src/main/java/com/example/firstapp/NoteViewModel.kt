package com.example.firstapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {
    private var repository: NoteRepository? = null
    private var allNotes: LiveData<List<Notes>>? = repository?.getAllNotes()

    fun insert(note: Notes) {
        repository?.insert(note)
    }

    fun deleteAllNotes() {
        repository?.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Notes>>? {
        return allNotes
    }
}
