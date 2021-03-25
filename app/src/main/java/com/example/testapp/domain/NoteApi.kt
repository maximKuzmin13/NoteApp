package com.example.testapp.domain

import retrofit2.Call
import retrofit2.http.GET

interface NoteApi {

    @GET("comments")
    fun list(): Call<List<FakeNotes>>

}