package com.example.testapp.core

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    companion object {
        const val SERVER_URL = "https://jsonplaceholder.typicode.com"
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@MyApp)

            modules(
                listOf(
                    coreModule,
                    viewmodels,
                    interactorModule,
                    repositoies,
                    serviceModule,
                    daoModule
                )
            )
        }

    }
}