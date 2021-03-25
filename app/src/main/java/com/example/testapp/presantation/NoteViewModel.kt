package com.example.testapp.presantation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.FakeNotes
import com.example.testapp.domain.NoteInterator
import com.example.testapp.domain.NoteRepository
import com.example.testapp.domain.Notes
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteViewModel(
    private val localRepository: NoteRepository,
    private val iterator: NoteInterator
) : ViewModel() {

    private var allNotes = localRepository.getAllNotes()
    val title = MutableLiveData<String>()
    val text = MutableLiveData<String>()
    private var fakeNotes = MutableLiveData<List<FakeNotes>>()
    private var isEmptyView = MutableLiveData<Boolean>()

//    private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

    fun setTitle(titleld: String) {
        title.value = titleld
    }

    fun setText(textLD: String) {
        text.value = textLD
    }

    fun delete(note: Notes?) {
        viewModelScope.launch {
            iterator.delete(note)
        }
    }

    fun deleteAllNotes() {
        viewModelScope.launch(IO) {
            localRepository.deleteAllNotes()
        }
    }

    fun downloadAllNotes(): LiveData<List<FakeNotes>>? {
        localRepository.downloadAllNotes(
            onNoteListSuccess = {
                fakeNotes.postValue(it)
            },
            onNoteListFail = {
                isEmptyView.postValue(true)
            }
        )
        return fakeNotes
    }

    fun getAllNotes(): LiveData<List<Notes>>? {
        return allNotes
    }


    fun saveNotes(id: Int?) {
        viewModelScope.launch {
            val notes = Notes(
                title = title.value.toString(),
                text = text.value.toString(),
                id = id ?: 0
            )
            iterator.insert(notes)
        }
    }


}
