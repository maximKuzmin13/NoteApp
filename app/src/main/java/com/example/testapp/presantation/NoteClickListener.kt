package com.example.testapp.presantation

import com.example.testapp.domain.Notes

interface NoteClickListener {
    fun onNoteClick(note: Notes?)
    fun onNoteDelete(note: Notes)
}