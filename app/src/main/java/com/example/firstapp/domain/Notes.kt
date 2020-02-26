package com.example.firstapp.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "text")
    var text: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "date")
    var noteDate: String
)
