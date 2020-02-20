package com.example.firstapp.domain

import androidx.lifecycle.LiveData

interface NoteRepository {
    suspend fun insert(note: Notes)
    fun deleteAllNotes()
    fun getAllNotes(): LiveData<List<Notes>>
}