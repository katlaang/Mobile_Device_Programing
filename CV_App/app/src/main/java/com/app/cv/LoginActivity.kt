package com.app.cv

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Login : AppCompatActivity() {
    var shp: SharedPreferences? = null
    var shpEditor: SharedPreferences.Editor? = null
    var edtUserId: EditText? = null
    var edtPassword: EditText? = null
    var btnLogin: Button? = null
    var txtInfo: TextView? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        edtUserId = findViewById(R.id.edtUserid)
        edtUserId?.setText("")
        edtPassword = findViewById(R.id.edtPassword)
        edtPassword?.setText("")
        btnLogin = findViewById(R.id.btnLogin)
        txtInfo = findViewById(R.id.txtInfo)
        shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
        checkLogin()
        btnLogin?.setOnClickListener {
            if (edtUserId?.text.toString() == "" || edtPassword?.text
                    .toString() == ""
            ) txtInfo?.text = "Please insert userid and password" else doLogin(
                edtUserId?.text.toString(), edtPassword?.text.toString()
            )
        }
    }

    private fun checkLogin() {
        if (shp == null) shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
        val userName = shp!!.getString("admin", "")
        if (userName != null && userName != "") {
            val i = Intent(this@Login, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun doLogin(userid: String?, password: String) {
        try {
            if (password == "admin") {
                if (shp == null) shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
                shpEditor = shp!!.edit()
                shpEditor?.putString("name", userid)
                shpEditor?.commit()
                val i = Intent(this@Login, MainActivity::class.java)
                startActivity(i)
                finish()
            } else txtInfo!!.text = "Invalid Credentials"
        } catch (ex: Exception) {
            txtInfo!!.text = ex.message.toString()
        }
    }
}
