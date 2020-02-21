package com.example.firstapp.presantation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.NoteRepository
import com.example.firstapp.domain.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository,
    private val iterator: NoteInterator
) : ViewModel() {
    private var allNotes = repository.getAllNotes()

    fun insert(note: Notes) {
        viewModelScope.launch(IO) {
            iterator.insert(note)
        }
    }
    fun deleteAllNotes() {
        viewModelScope.launch(IO) {
            repository.deleteAllNotes()
        }
    }
    fun getAllNotes(): LiveData<List<Notes>>? {
            return allNotes
    }
}
