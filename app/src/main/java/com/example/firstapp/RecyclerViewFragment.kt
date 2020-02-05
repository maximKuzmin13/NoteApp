package com.example.firstapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_notes.*
import com.example.firstapp.RecyclerViewFragment as RecyclerViewFragment1


class RecyclerViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
        }
        val recyclerAdapter = RecyclerAdapter()
        recycler_view.adapter = recyclerAdapter
        val numberList = ArrayList<Int>()
        for (i in 1..3) {
            numberList.add(i)
        }
        recyclerAdapter.setValue(numberList)
        add_note.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                    R.id.fl_content,
                    AddNoteFragment(),
                    AddNoteFragment::class.java.simpleName
                )?.addToBackStack(AddNoteFragment::class.java.simpleName)?.commit()
        }
    }
}