package com.example.recyclerlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var productList = ArrayList<Product>(arrayListOf(
        Product("Samsung S7",480.10,"Black",R.drawable.tablet.toString(),"101","The Tab S7 Plus is Samsung’s flagship model and offers all the bells and whistles you could want in a tablet. The giant, crisp screen is perfect for watching TV shows or doing serious work on things like spreadsheets or word processing documents."),
        Product("Epson XP-8700 ",343.10,"Black",R.drawable.printer.toString(),"102","Need excellent-quality borderless photos at sizes up to 8.5 by 11 inches? Epson's six-ink Expression Photo XP-8700 will get you those sharp prints, plus do some light-duty document handling"),
        Product("Lenovo Slim 7",450.10,"Silver",R.drawable.laptop.toString(),"104","Putting Pro in the name of a laptop model means different things to different people. In this case, it seems that it means moving a notch up from the regular IdeaPad Slim 7 in almost every way. The Slim 7i Pro (the letter i is for the Intel processor) has better components, a higher-quality display and some future-proofing tech, as well as some features to improve your work experience."),
        Product("Samsung QLED",600.75,"Silver",R.drawable.television.toString(),"105","The Neo QN900 QLED TV is a stunning TV that sets a new benchmark when it comes to high-end televisions. It's significantly brighter and shrinks down the bezel to almost nothing.")
    ))
    var myAdapter : MyAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        r1 = findViewById<RecyclerView>(R.id.rv)

        myAdapter = MyAdapter(this,productList)
        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = myAdapter

    }
}