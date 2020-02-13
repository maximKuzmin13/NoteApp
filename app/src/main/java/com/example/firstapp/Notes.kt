package com.example.firstapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Notes (var text: String) {
    fun getNoteText(): String {
    return text
    }
}