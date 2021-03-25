package com.example.testapp.data

import androidx.lifecycle.LiveData
import com.example.testapp.domain.NoteInterator
import com.example.testapp.domain.NoteRepository
import com.example.testapp.domain.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteInteratorImpl(private val repository: NoteRepository) : NoteInterator {
    override suspend fun insert(notes: Notes) {
        withContext(Dispatchers.IO) {
            repository.insert(notes)
        }
    }


    override suspend fun delete(notes: Notes?) {
        withContext(Dispatchers.IO) {
            repository.delete(notes)
        }
    }

    override suspend fun getAllNotes(): LiveData<List<Notes>> {
        return withContext(Dispatchers.IO) {
            repository.getAllNotes()
        }

    }


}