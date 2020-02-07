package com.example.firstapp

class NotesInterator {

    fun setTextInNote():List<Notes>{
        return NotesRepository().getFirstNotes()
    }
    fun getTextFrom(){

    }
}