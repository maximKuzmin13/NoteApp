package com.example.firstapp.domain

import androidx.lifecycle.LiveData

interface NoteInterator {
    fun insert(note: Notes)

    fun getAllNotes(): LiveData<List<Notes>>
}