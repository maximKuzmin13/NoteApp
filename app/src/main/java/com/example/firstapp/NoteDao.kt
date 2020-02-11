package com.example.firstapp

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface NoteDao {

    @Insert
    fun insert(note: Notes)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ")
    fun getAllNotes(): LiveData<List<Notes>>
}
