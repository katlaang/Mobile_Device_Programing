package com.quizapp

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    var score1 = 0
    var score2 = 0
    var points = 0

//    lateinit var first_answer:String
//    lateinit var second_answer:String

    var date: LocalDateTime = LocalDateTime.now()//using java local date api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radio_group.setOnCheckedChangeListener { group, checkedId ->
            //check the first question and store
            val radioGroup: RadioButton = radio_group.findViewById(checkedId)
            val checked = radioGroup.isChecked
            if(checked && radioGroup.text.toString() == "val"){
                score1 += 50
            }else if(checked && radioGroup.text.toString() != "public" && score1>0){
                score1 -=50
            }
        }
        //check the checkboxes and pick the correct answer. If correct is selected, add 50,
        //otherwise reduce 50

        pub.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) score2 += 50
        }

        prot.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked && score2 > 0) score2 -= 50

        }

        priv.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked && score2 > 0) score2 -= 50
        }
    }


    fun submit(view: View){

        points = score1 + score2
        val alertResult = AlertDialog.Builder(this)
        alertResult.setTitle("Your Quiz Result")
        val formatter = DateTimeFormatter. ofPattern("MM-dd-yyyy HH:mm:ss")
        val formatedTime = date.format(formatter)
        alertResult.setMessage("Congratulations! You submitted on $formatedTime, You achieved $points%")
        val alert: AlertDialog = alertResult.create()
        alert.show()
        clear()
    }

    fun clear(){
        score1 = 0
        score2 = 0
        points = 0
        pub.isChecked=false
        priv.isChecked = false
        prot.isChecked = false
        rb2.isChecked = false
        rb3.isChecked = false

    }

    fun reset(view : View){
        clear()
    }

}
