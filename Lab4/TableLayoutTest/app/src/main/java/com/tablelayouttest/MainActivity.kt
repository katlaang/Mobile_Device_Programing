package com.tablelayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TableRow
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun init() {
    if(vTxt.text.isEmpty() || cTxt.text.isEmpty()){
        if (vTxt.text.isEmpty()){
            vTxt.requestFocus()
        }
        else{
            cTxt.requestFocus()
        }
    }else{
        Toast.makeText(applicationContext, "All fields are required", Toast.LENGTH_LONG).show()
    }

        //make table rows
        val tableRow =TableRow(applicationContext)
        val layoutParams=TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(0,20,0,0)
        layoutParams.gravity= Gravity.BOTTOM
        tableRow.layoutParams=layoutParams


    val version=vTxt.text.toString().trim()
        val code=cTxt.text.toString().trim()
    }
}


