package com.example.firstapp.data

import androidx.lifecycle.LiveData
import android.os.AsyncTask
import com.example.firstapp.domain.Notes
import com.example.firstapp.domain.NoteRepository


class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {

    private val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()

    override fun insert(note: Notes) {
        InsertNoteAsyncTask(
            noteDao
        ).execute(note)
    }

    override fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Notes, Unit, Unit>() {

        override fun doInBackground(vararg note: Notes?) {
            noteDao.insert(note[0]!!)
        }
    }
}