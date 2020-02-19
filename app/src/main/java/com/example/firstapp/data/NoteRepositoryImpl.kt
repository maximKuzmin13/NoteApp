package com.example.firstapp.data

import androidx.lifecycle.LiveData
import android.os.AsyncTask
import com.example.firstapp.domain.Notes
import com.example.firstapp.domain.NoteRepository


class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {

    private val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()

    override fun insert(vararg note: Notes) {
        noteDao.insert(note[0])
    }

    override fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }


}