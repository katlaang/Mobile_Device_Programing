package com.tablelayouttest

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun init(view: View) {
        if (vTxt.text.isEmpty() || cTxt.text.isEmpty()) {
            if (vTxt.text.isEmpty()) {
                vTxt.requestFocus()
            } else {
                cTxt.requestFocus()
            }

            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
        }
//
        //make table rows
        val tableRow = TableRow(this)
        val layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 20, 0, 10)
        layoutParams.gravity = Gravity.BOTTOM
        tableRow.layoutParams = layoutParams

        //make new text views
        val newVersion = TextView(this)
        newVersion.text = vTxt.text
        newVersion.setTextColor(Color.parseColor("#FFFFFFFF"))
        newVersion.setBackgroundResource(R.color.version_row_color)
        layoutParams.gravity = Gravity.BOTTOM
        newVersion.layoutParams = layoutParams
        newVersion.textSize = 20F

        val newCodeName = TextView(this)
        newCodeName.text = cTxt.text
        newCodeName.setBackgroundResource(R.color.code_row_color)
        newVersion.setTextColor(getColor(R.color.black))
        layoutParams.gravity = Gravity.BOTTOM
        newCodeName.layoutParams = layoutParams
        newCodeName.textSize = 20F

        //add the text to the view
        tableRow.addView(newVersion)
        tableRow.addView(newCodeName)

        versionTable.addView(tableRow)

        vTxt.text.clear()
        cTxt.text.clear()

    }
}


