package com.example.testapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testapp.domain.Notes

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Notes)

    @Delete
    fun delete(note: Notes?)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ")
    fun getAllNotes(): LiveData<List<Notes>>
}
