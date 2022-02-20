package com.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    val dinnerList= arrayListOf( "Hamburger", "Pizza", "Mexican", "American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //clicklistener for decide button to select random food
        decideBtn.setOnClickListener{
            val random= Random()
            val selectedRandomFood=random.nextInt(dinnerList.size)
            randomSelectedFood.text=dinnerList[selectedRandomFood]

        }

        addFoodBtn.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            foodList.add(newFood)
            addFoodTxt.text.clear()
        }
    }

}