package com.example.recyclerlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var productList = ArrayList<Product>(arrayListOf(
        Product("Tablet",480.10,"Black",R.drawable.tablet.toString(),"101","The Tab S7 Plus is Samsung’s flagship model and offers all the bells and whistles you could want in a tablet. The giant, crisp screen is perfect for watching TV shows or doing serious work on things like spreadsheets or word processing documents."),
        Product("Printer",343.10,"Black",R.drawable.printer.toString(),"102","Need excellent-quality borderless photos at sizes up to 8.5 by 11 inches? Epson's six-ink Expression Photo XP-8700 will get you those sharp prints, plus do some light-duty document handling"),
        Product("Laptop",450.10,"Silver",R.drawable.laptop.toString(),"104","A laptop, often called a notebook, is a small, portable personal computer with a \"clamshell\" form factor, typically having a thin LCD or LED computer screen mounted on the inside of the upper lid of the clamshell and an alphanumeric keyboard on the inside of the lower lid."),
        Product("TeleVision",600.75,"Silver",R.drawable.television.toString(),"105","A television (also known as a TV) is a machine with a screen. Televisions receive broadcasting signals and turn them into pictures and sound. The word \"television\" comes from the words tele (Greek for far away) and vision (sight). Sometimes a television can look like a box.")
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