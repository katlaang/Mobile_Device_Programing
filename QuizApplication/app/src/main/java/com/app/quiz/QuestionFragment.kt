package com.app.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_question.view.*


class QuestionFragment : Fragment() {
    var currentQuizIndex = 0
    var quizzes = arrayOf<Quiz>()
    var answers = Array<QuizResult?>(0) { null }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_question)
        val json = inputStreamToString(resources.openRawResource(R.raw.quiz))
        quizzes = Gson().fromJson(json, Array<Quiz>::class.java)
        answers = Array(quizzes.size) { null }
        showQuiz(0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SHOW_RESULT_ACTIVITY_RESULT_CODE && resultCode == Activity.RESULT_OK) {
            reset()
        }
    }

        private fun reset() {
            currentQuizIndex = 0
            answers = Array(quizzes.size) { null }
            showQuiz(0)
        }

        private fun showQuiz(index: Int) {
            val quiz = quizzes[index]
            answer_radio_group.clearCheck()
            question_text_view.text = quiz.question
            answer_1_radio_button.text = quiz.answer1
            answer_2_radio_button.text = quiz.answer2
            answer_3_radio_button.text = quiz.answer3
            answer_4_radio_button.text = quiz.answer4
        }

        fun nextButtonClicked(view: View) {
            if (currentQuizIndex < quizzes.size - 1) {
                val selectedAnswer =
                    findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
                val result = QuizResult(quizzes[currentQuizIndex], selectedAnswer)
                answers[currentQuizIndex] = result
                currentQuizIndex++
                showQuiz(currentQuizIndex)
            } else {
                val selectedAnswer =
                    findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
                val result = QuizResult(quizzes[currentQuizIndex], selectedAnswer)
                answers[currentQuizIndex] = result
                val intent = Intent(this, QuizResultActivity::class.java)
                val arrayList = arrayListOf<QuizResult>()
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