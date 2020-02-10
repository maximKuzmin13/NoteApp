package com.example.firstapp

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface NoteDao {
    @Insert
    fun insert(note: Notes)

    @Query("SELECT * FROM note_table ORDER BY text DESC")
    fun getAllNotes(): LiveData<List<Notes>>

}
