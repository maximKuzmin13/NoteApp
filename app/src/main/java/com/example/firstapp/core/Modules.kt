package com.example.firstapp.core

import androidx.room.Room
import com.example.firstapp.data.NoteDatabase
import com.example.firstapp.data.NoteInteratorImpl
import com.example.firstapp.data.NoteRepositoryImpl
import com.example.firstapp.domain.NoteInterator
import com.example.firstapp.domain.NoteRepository
import com.example.firstapp.presantation.NoteViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodels = module {
    viewModel {NoteViewModel(get(),get()) }
}
val interactorModule = module {
    single<NoteInterator> { NoteInteratorImpl(get()) }
}
val repositoies = module {
    single<NoteRepository> { NoteRepositoryImpl(get()) }

    single {
        get<NoteDatabase>().noteDao()
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java, "FirstApp"
        ).build()
    }
 }
