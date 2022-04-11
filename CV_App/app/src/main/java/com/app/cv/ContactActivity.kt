package com.app.cv

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import kotlinx.android.synthetic.main.activity_contact.*
import kotlinx.android.synthetic.main.activity_main.*


class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        setSupportActionBar(toolbar_contact)
        toolbar_contact.title

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            android.R.id.home -> {
//                NavUtils.navigateUpFromSameTask(this)
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}