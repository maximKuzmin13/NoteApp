package com.example.firstapp.presantation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.NoteRepository
import com.example.firstapp.domain.Notes
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*

class NoteViewModel(
    private val repository: NoteRepository,
    private val iterator: NoteInterator
) : ViewModel() {
    private var allNotes = repository.getAllNotes()
    val title = MutableLiveData<String>()
    val text = MutableLiveData<String>()

    fun setTitle(titleld: String) {
        title.value = titleld
    }

    fun setText(textLD: String) {
        text.value = textLD
    }
//    fun insert(note: Notes) {
//        viewModelScope.launch {
//            iterator.insert(note)
//        }
//    }

    fun deleteAllNotes() {
        viewModelScope.launch(IO) {
            repository.deleteAllNotes()
        }
    }

    fun getAllNotes(): LiveData<List<Notes>>? {
        return allNotes
    }

    fun saveNotes(id: Int?) {
        viewModelScope.launch {
            val notes = Notes(
                title = title.value.toString(),
                text = text.value.toString(),
                noteDate = Date().toString(),
                id = id ?: 0
            )
            iterator.insert(notes)
        }
    }
}
