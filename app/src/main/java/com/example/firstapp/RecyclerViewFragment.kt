package com.example.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_notes.*


class RecyclerViewFragment : Fragment() {
    private lateinit var noteViewModel: NoteViewModel
    private val adapter = RecyclerAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_notes, container, false)

        noteViewModel = ViewModelProvider(this@RecyclerViewFragment).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes()?.observe(viewLifecycleOwner, Observer<List<Notes>> { notes ->
                adapter.setNotes(notes)
            })
        (activity as AppCompatActivity).supportActionBar?.title = "Заметки"
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerview.adapter = RecyclerAdapter()
        add_note.setOnClickListener {

            activity?.supportFragmentManager?.beginTransaction()?.add(R.id.fl_content,
                AddNoteFragment()
            )?.addToBackStack(null)?.commit()
        }
    }
}