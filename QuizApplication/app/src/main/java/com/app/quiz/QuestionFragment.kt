package com.app.quiz

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_question.view.*
import kotlinx.android.synthetic.main.fragment_quiz.view.*


class QuestionFragment : Fragment() {
    var currentQuestionIndex = 0
    var questions = arrayOf<Question>()
    var answers = Array<QuestionResult?>(3) { null }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_question, container, false)
        view.kotlin.setOnClickListener {
            val action = QuizFragmentDirections.questionFragmentToQuestionFragment(questions currentQuestionIndex)
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }

        private fun showQuiz(index: Int) {
            val quiz = questions[index]
            answer_radio_group.clearCheck()
            question_text_view.text = quiz.question
            answer_1_radio_button.text = quiz.answer1
            answer_2_radio_button.text = quiz.answer2
            answer_3_radio_button.text = quiz.answer3
        }

        fun nextButtonClicked(view: View) {
            if (currentQuestionIndex < questions.size - 1) {
                val selectedAnswer =
                    findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
                val result = QuestionResult(questions[currentQuestionIndex], selectedAnswer)
                answers[currentQuestionIndex] = result
                currentQuestionIndex++
                showQuiz(currentQuestionIndex)
            } else {
                val selectedAnswer =
                    findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
                val result = QuestionResult(questions[currentQuestionIndex], selectedAnswer)
                answers[currentQuestionIndex] = result
                val intent = Intent(this, QuestionResult::class.java)
                val arrayList = arrayListOf<QuestionResult>()
                arrayList.addAll(answers.filterNotNull())
                intent.putParcelableArrayListExtra("result", arrayList)
                startActivityForResult(intent, SHOW_RESULT_ACTIVITY_RESULT_CODE)
            }
        }

        fun homeButtonClicked(view: View) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        companion object {
            const val SHOW_RESULT_ACTIVITY_RESULT_CODE = 1
            fun inputStreamToString(inputStream: InputStream): String? {
                return try {
                    val bytes = ByteArray(inputStream.available())
                    inputStream.read(bytes, 0, bytes.size)
                    String(bytes)
                } catch (e: IOException) {
                    null
                }
            }
        }
    }
}