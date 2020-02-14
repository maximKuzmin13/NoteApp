package com.example.firstapp

import androidx.lifecycle.LiveData
import android.os.AsyncTask


class NoteRepositoryImpl(private val noteDao: NoteDao) {

    private val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()

    fun insert(note: Notes) {
        InsertNoteAsyncTask(
            noteDao
        ).execute(note)
    }

    fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Notes, Unit, Unit>() {

        override fun doInBackground(vararg note: Notes?) {
            noteDao.insert(note[0]!!)
        }
    }
}