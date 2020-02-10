package com.example.firstapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_text.*
import kotlinx.android.synthetic.main.item_recycler.*

class AddNoteFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Новая заметка"

        return inflater.inflate(R.layout.fragment_text, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savebtn.setOnClickListener{
            saveNote()
            activity?.supportFragmentManager?.popBackStack()
        }
    }
    private fun saveNote() {
        if (text_note.text.toString().trim().isBlank()) {
            return
        }
        val data = Intent().apply {
            putExtra("1233",text_note.text.toString())
        }
        activity?.setResult(Activity.RESULT_OK, data)
        activity?.finish()
    }
}
