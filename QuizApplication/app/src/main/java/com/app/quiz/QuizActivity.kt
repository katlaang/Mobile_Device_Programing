package com.app.quiz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_quiz.*
import java.io.IOException
import java.io.InputStream

class QuizActivity : AppCompatActivity() {

    var currentQuizIndex = 0
    var quiz = arrayOf<Question>()
    var answers = Array<QuizResult?>(0) { null }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val json = inputStreamToString(resources.openRawResource(R.raw.quiz))
        quiz = Gson().fromJson(json, Array<Question>::class.java)
        answers = Array(quiz.size) { null }
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
        answers = Array(quiz.size) { null }
        showQuiz(0)
    }

    private fun showQuiz(index: Int) {
        val quiz = quiz[index]
        answer_radio_group.clearCheck()
        question_text_view.text = quiz.question
        answer_1_radio_button.text = quiz.answer1
        answer_2_radio_button.text = quiz.answer2
        answer_3_radio_button.text = quiz.answer3
        answer_4_radio_button.text = quiz.answer4
    }

    fun nextButtonClicked(view: View) {
        if (currentQuizIndex < quiz.size - 1) {
            val selectedAnswer =
                findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
            val result = QuizResult(quiz[currentQuizIndex], selectedAnswer)
            answers[currentQuizIndex] = result
            currentQuizIndex++
            showQuiz(currentQuizIndex)
        } else {
            val selectedAnswer =
                findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
            val result = QuizResult(quiz[currentQuizIndex], selectedAnswer)
            answers[currentQuizIndex] = result
            val intent = Intent(this, ResultFragment::class.java)
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