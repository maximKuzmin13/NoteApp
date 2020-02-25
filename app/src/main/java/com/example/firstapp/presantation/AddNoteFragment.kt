package com.example.firstapp.presantation

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import kotlinx.android.synthetic.main.fragment_text.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat


class AddNoteFragment : BaseFragment(){
    override var titleId: Int = 0
    private val noteViewModel: NoteViewModel by inject()
    private val format = "yyyy.MM.dd \n     hh:mm"
    @SuppressLint("SimpleDateFormat")
    private val dateFormat = SimpleDateFormat(format)

    companion object {
        const val TAG = "AddNoteFragment"
        private const val ID_ARG = "ID_ARG"
        private const val TEXT_ARG = "TEXT_ARG"
        private const val TITLE_ARG = "TITLE_ARG"
        private const val TITLE_NOTE_ARG = "TITLE_NOTE_ARG"

        fun newInstance(title_note: String,text : String, title : String): Fragment {
            val fragment = AddNoteFragment()
            val bundle = Bundle()
   //         bundle.putInt(ID_ARG,id)
            bundle.putString(TITLE_NOTE_ARG, title_note)
            bundle.putString(TEXT_ARG,text)
            bundle.putString(TITLE_ARG,title)
            fragment.arguments = bundle
            return fragment
        }
    }

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

        arguments?.getString(TITLE_NOTE_ARG)?.let {
            toolbar_adding_note?.title = it
        } ?: run {
            toolbar_adding_note?.title = context?.getString(R.string.add_note)
        }

        toolbar_adding_note?.setNavigationOnClickListener { activity?.onBackPressed() }
        title_edit?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                savebtn.isEnabled = title_edit.length() > 1
                val inputTitle = title_edit.text.toString()
                noteViewModel.setTitle(inputTitle)
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
        text_note?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                savebtn.isEnabled = text_note.length() > 1
                val inputText = text_note.text.toString()
                noteViewModel.setText(inputText)
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        arguments?.getString(TITLE_ARG)?.let {
            title_edit.setText(it)
        } ?: run {
            title_edit.text = title_edit.text
        }
        arguments?.getString(TEXT_ARG)?.let {
            text_note.setText(it)
        }?: run{
            text_note.text = text_note.text
        }
        savebtn.setOnClickListener{
            noteViewModel.saveNotes()
            activity?.supportFragmentManager?.popBackStack()
        }
    }
}