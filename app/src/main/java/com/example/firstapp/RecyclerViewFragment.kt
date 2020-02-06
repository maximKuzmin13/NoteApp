package com.example.firstapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*

class RecyclerViewFragment : Fragment() {

    private val notesViewModel by lazy { ViewModelProviders.of(this).get(NotesViewModel::class.java)}

    override fun onResume() {
        super.onResume()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerAdapter = RecyclerAdapter()
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = recyclerAdapter
        notesViewModel.getNoteList().observe(this, Observer { it?.let { recyclerAdapter.setNotes(it) } })
        add_note.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.fl_content,
                AddNoteFragment()
            )?.addToBackStack(null)?.commit()
        }
    }
}