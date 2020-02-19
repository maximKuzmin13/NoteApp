package com.example.firstapp.domain

import androidx.lifecycle.LiveData

interface NoteInterator {
    suspend fun insert(notes: Notes)
    fun getAllNotes(): LiveData<List<Notes>>
}