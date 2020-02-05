package com.example.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_text.*

class AddNoteFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savebtn.setOnClickListener{

            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.fl_content,
                RecyclerViewFragment(),
                RecyclerViewFragment::class.java.simpleName
            )?.commit()
        }
    }
}