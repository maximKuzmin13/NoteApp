package com.example.firstapp.data

import androidx.lifecycle.LiveData
import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.NoteRepository
import com.example.firstapp.domain.Notes

class NoteInteratorImpl(private val repository: NoteRepository) : NoteInterator {
    override suspend fun insert(notes : Notes) {
        repository.insert(notes)
    }

    override fun getAllNotes(): LiveData<List<Notes>> {
        return repository.getAllNotes()
    }


}