package com.example.firstapp.presantation

import com.example.firstapp.domain.Notes

interface NoteClickListener {
    fun onNoteClick(note: Notes)
}