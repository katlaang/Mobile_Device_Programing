package com.app.quiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class QuestionResultAdapter(private val quizResults: ArrayList<QuestionResult>) :
    RecyclerView.Adapter<QuizResultAdapter.QuizResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.question_result_row_item, parent, false)
        return QuizResultViewHolder(view)
    }

    override fun getItemCount() = quizResults.size

    override fun onBindViewHolder(holder: QuizResultViewHolder, position: Int) {
        val result = quizResults[position]
        holder.configure(result, position)
    }

    class QuizResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val questionTextView: TextView = view.findViewById(R.id.question_text_view)
        private val selectedAnswerTextView: TextView =
            view.findViewById(R.id.selected_answer_text_view)
        private val correctAnswerTextView: TextView =
            view.findViewById(R.id.correct_answer_text_view)

        fun configure(quizResult: QuestionResult, position: Int) {
            questionTextView.text = quizResult.question
            selectedAnswerTextView.text = "Your answer: ${quizResult.selectedAnswer}"
            correctAnswerTextView.text = "Correct answer: ${quizResult.correctAnswer}"
        }
    }
}