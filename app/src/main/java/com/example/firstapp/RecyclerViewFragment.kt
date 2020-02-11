import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.AddNoteFragment
import com.example.firstapp.Notes
import com.example.firstapp.R
import com.example.firstapp.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_notes.*


class RecyclerViewFragment : Fragment() {
    private val textList = ArrayList<String>()
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
        val recyclerAdapter = RecyclerAdapter()

        recycler_view.adapter = recyclerAdapter
        add_note.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.add(R.id.fl_content,
                AddNoteFragment()
            )?.addToBackStack(null)?.commit()
        }
    }
}