package com.app.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_quiz.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)
        view.kotlin.setOnClickListener {
            val action = QuizFragmentDirections.quizFragmentToQuestionFragment("kotlin")
            Navigation.findNavController(view).navigate(action)
        }
        view.c.setOnClickListener {
            val action = QuizFragmentDirections.quizFragmentToQuestionFragment("c")
            Navigation.findNavController(view).navigate(action)
        }
        view.database.setOnClickListener {
            val action = QuizFragmentDirections.quizFragmentToQuestionFragment("database")
            Navigation.findNavController(view).navigate(action)
        }



        return view
    }
}