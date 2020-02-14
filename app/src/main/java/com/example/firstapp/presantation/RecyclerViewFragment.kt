package com.example.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.domain.Notes
import com.example.firstapp.presantation.AddNoteFragment
import com.example.firstapp.presantation.NoteViewModel
import kotlinx.android.synthetic.main.fragment_notes.*
import org.koin.android.ext.android.inject


class RecyclerViewFragment : Fragment() {
    private val adapter = RecyclerAdapter()

    private val noteViewModel: NoteViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Заметки"
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerview.adapter = this.adapter

        noteViewModel.getAllNotes()?.observe(viewLifecycleOwner, Observer<List<Notes>> { notes ->
            adapter.setNotes(notes)
        })


        add_note.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.add(
                R.id.fl_content,
                AddNoteFragment()
            )?.addToBackStack(null)?.commit()
        }
    }
}