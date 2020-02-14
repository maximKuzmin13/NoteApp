package com.example.firstapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Notes (
    @PrimaryKey
    var text: String
)