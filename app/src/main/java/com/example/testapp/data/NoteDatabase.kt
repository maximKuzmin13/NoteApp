package com.example.testapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.domain.Notes

@Database(entities = [Notes::class], version = 2)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
