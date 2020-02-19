package com.example.firstapp.domain

import androidx.lifecycle.LiveData

interface NoteRepository {
    suspend fun insert(vararg note: Notes)
    fun getAllNotes(): LiveData<List<Notes>>
}