package com.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    val dinnerList= arrayListOf( "Hamburger", "Pizza", "Mexican", "American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    //clicklistener for decide button to select random food
        decideButton.setOnClickListener{
            val random= Random()
            val selectedRandomFood=random.nextInt(dinnerList.size)
            randomSelectedFood.text=dinnerList[selectedRandomFood]

        }

        addFoodButton.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            dinnerList.add(newFood)
            addFoodTxt.text.clear()
        }
    }

}