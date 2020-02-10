package com.example.firstapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel(application: Application) : ViewModel() {
    private var repository: NoteRepository =
        NoteRepository(application)
    private var allNotes: LiveData<List<Notes>> = repository.getAllNotes()

    fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }
}