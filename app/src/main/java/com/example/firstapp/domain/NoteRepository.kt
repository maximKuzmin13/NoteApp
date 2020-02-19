package com.example.firstapp.domain

import androidx.lifecycle.LiveData

interface NoteRepository {
    fun insert(vararg note: Notes)
    fun getAllNotes(): LiveData<List<Notes>>
}