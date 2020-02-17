package com.example.firstapp.data

import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.Notes
import com.example.firstapp.presantation.RecyclerViewFragment

class NoteInteratorImpl : NoteInterator {

    override fun insert(note: Notes) {
        RecyclerViewFragment().noteViewModel.insert(note)
    }


}