package com.example.firstapp.core

import androidx.room.Room
import com.example.firstapp.data.NoteDao
import com.example.firstapp.data.NoteDatabase
import com.example.firstapp.presantation.NoteViewModel
import com.example.firstapp.data.NoteRepositoryImpl
import com.example.firstapp.domain.NoteRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodels = module {
    viewModel { NoteViewModel(get<NoteRepository>()) }
}

val repositoies = module {
    single<NoteRepository> { NoteRepositoryImpl(get()) }

    single<NoteDao> {
        get<NoteDatabase>().noteDao()
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java, "FirstApp"
        ).build()
    }
}
