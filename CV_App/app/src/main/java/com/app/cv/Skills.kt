package com.app.cv

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_skills.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_SKILLS= "skills"

/**
 * A simple [Fragment] subclass.
 * Use the [Skills.newInstance] factory method to
 * create an instance of this fragment.
 */
class Skills : Fragment() {
    // TODO: Rename and change types of parameters
    private var skills: ArrayList<String> = mutableListOf("Kotlin", "Fashion design", "Filling tax forms") as ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            skills = it.getStringArrayList(ARG_SKILLS) as ArrayList<String>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_skills, container, false)

        var listView:ListView = view.findViewById(R.id.skillsView) as ListView

        var listViewAdapter: ArrayAdapter<String> = ArrayAdapter(requireActivity(),
            android.R.layout.simple_list_item_1,
            skills)

        view.btn_add_new_skill.setOnClickListener {
            var skill:String = view.et_add_new_skill.text.toString()
            Skills().skills.add(skill)
            listViewAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), "Added into List ${ skill }", Toast.LENGTH_LONG).show()
        }

        listView.adapter = listViewAdapter

        return view

    }

}

