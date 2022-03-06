package com.example.walmart

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     var users= ArrayList<User>()
    var correctDetailsFlag=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user=User("Eunice", "Myllynen", "emyllynen@g.com", "1234")
        val user1 = User("John", "Doe", "user1@walmart.com", "John")
        val user2 = User("Jane", "Doe", "user2@walmart.com", "Jane")
        val user3 = User("Ken", "Doll", "user4@gmail.com", "Ken")
        val user4 = User("Mary", "Keith", "user4@gmail.com", "Mary")
        val user5 = User("Nicholas", "Lance", "user5@gmail.com", "Nico")
        users.add(user1)
        users.add(user2)
        users.add(user3)
        users.add(user4)
        users.add(user5)

    }
    fun login(view:View) {
        for (i in users) {
            val uname: String = i.userName
            val upassword: String = i.password
            if (et1.text.toString().equals(uname) && et2.text.toString().equals(upassword)) {
                correctDetailsFlag = true

                    var intent = Intent(this, ShopByCategory::class.java)
                    intent.putExtra("user", uname)
                    startActivity(intent)
                    break

            }

        }
    }

    fun createAccount(view: View){
        val intent = Intent(this,Register::class.java)
        startActivity(intent)

    }
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode == Activity.RESULT_OK){
                if(data != null){
                    val ReturnedResult = data.getSerializableExtra("newUser") as User
                    users.add(ReturnedResult)
                    Toast.makeText(this, "Account created successfully as user name of ${ReturnedResult.userName}", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    fun getPassword(view: View){
        if(tv4.text.isNotEmpty()){
            var pass:String? = null
            for(i in users){
                if(i.userName==et1.text.toString()){
                    pass = i.password
                    break
                }
            }
            if(pass != null){
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, pass)
                startActivity(intent)
            }
        }
    }

}