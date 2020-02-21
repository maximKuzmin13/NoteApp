package com.example.firstapp.presantation

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.domain.Notes
import kotlinx.android.synthetic.main.fragment_text.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*


class AddNoteFragment: Fragment(){
    private val noteViewModel: NoteViewModel by inject()
    private val format = "yyyy.MM.dd \n     hh:mm"
    @SuppressLint("SimpleDateFormat")
    private val dateFormat = SimpleDateFormat(format)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar_adding_note)
        toolbar_adding_note?.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        val addNoteString = context?.getString(R.string.add_note)
        toolbar_adding_note?.title = addNoteString
        toolbar_adding_note?.setNavigationOnClickListener { activity?.onBackPressed() }
        text_note?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                savebtn.isEnabled = text_note.length() > 1
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
        savebtn.setOnClickListener{
            val text = text_note.text.toString()
            val title = title_edit.text.toString()
            val date = dateFormat.format(Date())
            noteViewModel.insert(Notes(text,title,date))
            val titleString = context?.getString(R.string.notes)
            (activity as AppCompatActivity).supportActionBar?.title = titleString
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}