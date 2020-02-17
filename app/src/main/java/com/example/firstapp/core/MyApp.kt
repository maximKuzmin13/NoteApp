package com.example.firstapp.core

import android.app.Application
import com.example.firstapp.core.repositoies
import com.example.firstapp.core.viewmodels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin!
        startKoin {
            // Android context
            androidContext(this@MyApp)
            // modules
            modules(listOf(viewmodels,interactorModule, repositoies ))
        }

    }
}