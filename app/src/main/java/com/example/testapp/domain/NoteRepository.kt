package com.example.testapp.domain

import androidx.lifecycle.LiveData

interface NoteRepository {
    fun insert(note: Notes)
    suspend fun delete(note: Notes?)
    fun deleteAllNotes()
    fun getAllNotes(): LiveData<List<Notes>>
    fun downloadAllNotes(
        onNoteListSuccess: (List<FakeNotes>?) -> Unit,
        onNoteListFail: (Throwable?) -> Unit
    )
}