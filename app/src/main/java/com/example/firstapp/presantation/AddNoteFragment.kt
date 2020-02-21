package com.example.firstapp.presantation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.domain.Notes
import kotlinx.android.synthetic.main.fragment_text.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*


class AddNoteFragment: Fragment(){
    val noteViewModel: NoteViewModel by inject()
    val format = "yyyy.MM.dd \n     hh:mm"
    val dateFormat = SimpleDateFormat(format)
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val newNoteString = context?.getString(R.string.new_note)
        (activity as AppCompatActivity).supportActionBar?.title = newNoteString
        return inflater.inflate(R.layout.fragment_text, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.cancel_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cancel_note -> {
                activity?.supportFragmentManager?.popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}