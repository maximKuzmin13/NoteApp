package com.example.testapp.domain

import com.google.gson.annotations.SerializedName

data class FakeNotes(
    @SerializedName("id")
    var id: Int,
    @SerializedName("body")
    var text: String,
    @SerializedName("name")
    var title: String
)