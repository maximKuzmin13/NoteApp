package com.example.firstapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.firstapp.domain.Notes

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Notes)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ")
    fun getAllNotes(): LiveData<List<Notes>>
}
