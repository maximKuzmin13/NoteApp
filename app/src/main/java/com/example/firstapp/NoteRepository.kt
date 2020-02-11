package com.example.firstapp

import androidx.lifecycle.LiveData
import android.os.AsyncTask


class NoteRepository(private val noteDao: NoteDao) {

    private val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()

    fun insert(note: Notes) {
        InsertNoteAsyncTask(
            noteDao
        ).execute(note)
    }

    fun deleteAllNotes() {
        DeleteAllNotesAsyncTask(
            noteDao
        ).execute()
    }

    fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Notes, Unit, Unit>() {

        override fun doInBackground(vararg note: Notes?) {
            noteDao.insert(note[0]!!)
        }
    }


    private class DeleteAllNotesAsyncTask(val noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }

}