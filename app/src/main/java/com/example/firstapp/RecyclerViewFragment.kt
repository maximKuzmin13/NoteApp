package com.example.firstapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*


class RecyclerViewFragment : Fragment() {
    private lateinit var noteViewModel: NoteViewModel

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
        recycler_view.layoutManager = LinearLayoutManager(activity)
        val adapter = RecyclerAdapter()
        recycler_view.adapter = adapter
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)// Здесь ставится курсор ошибки
        noteViewModel.getAllNotes().observe(viewLifecycleOwner, Observer<List<Notes>> {})
        add_note.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.fl_content,
                AddNoteFragment()
            )?.addToBackStack(null)?.commit()
        }
    }
}