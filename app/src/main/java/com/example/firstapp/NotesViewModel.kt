package com.example.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel: ViewModel() {
    var notesList : MutableLiveData<List<Notes>> = MutableLiveData()

    init {notesList.value = NotesInterator().setTextInNote()}

    fun getNoteList() = notesList
    fun addTextNote(){

    }
}