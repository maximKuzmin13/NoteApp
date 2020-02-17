package com.example.firstapp.domain

import androidx.lifecycle.LiveData

interface NoteInterator {
    fun insert(notes: Notes)
    fun getAllNotes(): LiveData<List<Notes>>
}