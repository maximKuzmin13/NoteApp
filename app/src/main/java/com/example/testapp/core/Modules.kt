package com.example.testapp.core

import androidx.room.Room
import com.example.testapp.data.NoteDatabase
import com.example.testapp.data.NoteInteratorImpl
import com.example.testapp.data.NoteRepositoryImpl
import com.example.testapp.domain.NoteApi
import com.example.testapp.domain.NoteInterator
import com.example.testapp.domain.NoteRepository
import com.example.testapp.presantation.NoteViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coreModule = module {
    single<Retrofit> {

        Retrofit.Builder()
            .baseUrl(MyApp.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single<Gson> {
        GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
            .setLenient()
            .create()
    }


    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java, "NoteApp"
        ).fallbackToDestructiveMigrationFrom(1).build()
    }
}

val viewmodels = module {
    viewModel { NoteViewModel(get(), get()) }
}
val interactorModule = module {
    single<NoteInterator> { NoteInteratorImpl(get()) }

}

val serviceModule = module {
    single {
        get<Retrofit>().create(NoteApi::class.java)
    }

}

val repositoies = module {
    single<NoteRepository> { NoteRepositoryImpl(get(), get()) }

}

val daoModule = module {
    single {
        get<NoteDatabase>().noteDao()
    }
}