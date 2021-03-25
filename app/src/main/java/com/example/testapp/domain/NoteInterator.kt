package com.example.testapp.domain

import androidx.lifecycle.LiveData

interface NoteInterator {
    suspend fun insert(notes: Notes)
    suspend fun delete(notes: Notes?)
    suspend fun getAllNotes(): LiveData<List<Notes>>
}