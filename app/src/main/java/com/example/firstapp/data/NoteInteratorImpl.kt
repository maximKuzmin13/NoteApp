package com.example.firstapp.data

import androidx.lifecycle.LiveData
import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.NoteRepository
import com.example.firstapp.domain.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteInteratorImpl(private val repository: NoteRepository) : NoteInterator {
    override suspend fun insert(notes : Notes) {
        withContext(Dispatchers.IO) {
            repository.insert(notes)
        }
    }

    override fun getAllNotes(): LiveData<List<Notes>> {
        return repository.getAllNotes()
    }


}