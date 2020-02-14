package com.example.firstapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firstapp.domain.Notes


@Database(entities = [Notes::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}