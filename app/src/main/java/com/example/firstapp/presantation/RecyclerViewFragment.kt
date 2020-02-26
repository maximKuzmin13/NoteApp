package com.example.firstapp.presantation

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.domain.Notes
import kotlinx.android.synthetic.main.fragment_notes.*
import org.koin.android.ext.android.inject


class RecyclerViewFragment : Fragment(),NoteClickListener {
    private val adapter = RecyclerAdapter()
    private val noteViewModel: NoteViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(toolbar_recycler)
        val recyclerview = view.findViewById<RecyclerView>(R.id.recycler_view)
        val topPaddingDecoration = RecyclerItemDecorator(30)
        recyclerview.addItemDecoration(topPaddingDecoration)
        recyclerview.adapter = this.adapter
        adapter.setListener(this)
        noteViewModel.getAllNotes()?.observe(viewLifecycleOwner, Observer<List<Notes>> { notes ->
            adapter.setNotes(notes)
        })
        add_note.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.fl_content,
                AddNoteFragment()
            )?.addToBackStack(AddNoteFragment.TAG)?.commit()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_all_notes -> {
                noteViewModel.deleteAllNotes()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
    override fun onNoteClick(note: Notes) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
        R.id.fl_content,
        AddNoteFragment.newInstance(
            note.id,
            context?.getString(R.string.edit_title)!!,
            note.text,
            note.title
            )
    )?.addToBackStack(null)?.commit()
    }
}