package com.example.firstapp.presantation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.core.viewmodels
import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.Notes
import com.example.firstapp.domain.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository,
    private val iterator: NoteInterator
) : ViewModel() {
    private var viewModelJob = Job()
    private val viewModelScope = CoroutineScope(IO + viewModelJob)
    private var allNotes = repository.getAllNotes()

    fun insert(note: Notes) {
        viewModelScope.launch(IO) {
            iterator.insert(note)
        }
    }
    fun getAllNotes(): LiveData<List<Notes>>? {
            return allNotes
    }
}