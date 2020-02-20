package com.example.firstapp.data

import androidx.lifecycle.LiveData
import com.example.firstapp.domain.NoteRepository
import com.example.firstapp.domain.Notes


class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {

    private val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()

    override suspend fun insert(note: Notes) {
        noteDao.insert(note)
    }

    override fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }

    override fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }


}