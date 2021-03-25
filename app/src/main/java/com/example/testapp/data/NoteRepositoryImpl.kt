package com.example.testapp.data

import androidx.lifecycle.LiveData
import com.example.testapp.domain.FakeNotes
import com.example.testapp.domain.NoteApi
import com.example.testapp.domain.NoteRepository
import com.example.testapp.domain.Notes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NoteRepositoryImpl(private val noteDao: NoteDao, private val api: NoteApi) : NoteRepository {

    private val allNotes: LiveData<List<Notes>> = noteDao.getAllNotes()

    override fun insert(note: Notes) {
        noteDao.insert(note)
    }

    override suspend fun delete(note: Notes?) {
        noteDao.delete(note)
    }


    override fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }


    override fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }

    override fun downloadAllNotes(
        onNoteListSuccess: (List<FakeNotes>?) -> Unit,
        onNoteListFail: (Throwable?) -> Unit
    ) {
        api.list().enqueue(object : Callback<List<FakeNotes>> {
            override fun onResponse(
                call: Call<List<FakeNotes>>?,
                response: Response<List<FakeNotes>>?
            ) {
                onNoteListSuccess(response?.body())
            }

            override fun onFailure(call: Call<List<FakeNotes>>?, t: Throwable?) {
                onNoteListFail(t)
            }
        })

    }


}