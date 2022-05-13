package com.app.quiz

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuizResult(val question: String, val selectedAnswer: String, val correctAnswer: String) :
    Parcelable {

    constructor(question: Question, selectedAnswer: String) : this(
        question.question,
        selectedAnswer,
        arrayOf(question.answer1, question.answer2, question.answer3)[question.correctAnswer]
    )

}