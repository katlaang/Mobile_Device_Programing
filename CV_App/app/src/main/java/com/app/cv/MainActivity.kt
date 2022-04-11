package com.app.cv

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var txtInfo: TextView? = null
    var btnLogOut: Button? = null

    var shp: SharedPreferences? = null
    var shpEditor: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewPager(viewPager)
        setUpIcons()

        txtInfo = findViewById(R.id.txtInfo)
        btnLogOut = findViewById(R.id.btnLogOut)
        shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
        checkLogin()

        btnLogOut?.setOnClickListener {
            logout()
        }
    }


    private fun setupViewPager(viewPager: ViewPager){ //private method to set up the swipe views
        val  viewPagerAdapter=ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment(), "Home")
        viewPagerAdapter.addFragment(Education(), "Education")
        viewPagerAdapter.addFragment(Skills(), "Skills")
        viewPagerAdapter.addFragment(Work(), "Work")
/*        If these are added Hobbies opens but the other two won't, so something wrong with fragments
viewPagerAdapter.addFragment(Hobbies(), "Hobbies")
        viewPagerAdapter.addFragment(References(), "References")
        viewPagerAdapter.addFragment(Contact(), "Contact")*/

        viewPager.adapter=viewPagerAdapter
    }

    private fun setUpIcons(){
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.icon_home)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.icon_education)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.icon_skills)
        tabLayout.getTabAt(3)!!.setIcon(R.drawable.icon_work)
/*        tabLayout.getTabAt(4)!!.setIcon(R.drawable.icon_hobbies)
        tabLayout.getTabAt(5)!!.setIcon(R.drawable.icon_references)
        tabLayout.getTabAt(6)!!.setIcon(R.drawable.icon_contact)*/
    }

    @SuppressLint("SetTextI18n")
    private fun  checkLogin() {
        if (shp == null)
            shp = getSharedPreferences("myPreferences", MODE_PRIVATE);


        val userName = shp?.getString("name", "");

        if (userName != null && userName != "") {
            txtInfo?.text = "Welcome $userName"

        } else
        {
            val loginIntent = Intent(this@MainActivity, Login::class.java);
            startActivity(loginIntent);
            finish();
        }
    }


    private fun logout() {
        try {
            if (shp == null) shp = getSharedPreferences("myPreferences", MODE_PRIVATE)
            shpEditor = shp!!.edit()
            shpEditor?.putString("name", "")
            shpEditor?.commit()
            val i = Intent(this@MainActivity, Login::class.java)
            startActivity(i)
            finish()
        } catch (ex: Exception) {
            Toast.makeText(this@MainActivity, ex.message.toString(), Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // menu?.clear()
        menuInflater.inflate(R.menu.menu_main, menu);
        if(menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        //return super.onCreateOptionsMenu(menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       // val fmanager=supportFragmentManager
        val intentContact= Intent(this, ContactActivity::class.java)
        val intentHobbies= Intent(this, HobbiesActivity::class.java)
        val intentReferences=Intent(this, ReferencesActivity::class.java)
        return when(item.itemId) {

            R.id.action_contact -> {
                startActivity(intentContact)
                return true
            }
            R.id.action_hobbies -> {
                startActivity(intentHobbies)
                return true
            }

            R.id.action_references -> {
                startActivity(intentReferences)
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }


//
//
////          fmanager.beginTransaction()
////                .replace(R.id.id_activity_main, Contact())
////                .commit() > 0
////        R.id.action_contact -> {
////
////            fmanager.beginTransaction()
////             .replace(R.id.id_activity_main, Contact())
////              .commit()
////            return true
////        }
//            R.id.id_hobbies -> fmanager.beginTransaction()
//                .replace(R.id.id_hobbies, Hobbies())
//                .commit() > 0
//            R.id.id_references -> fmanager.beginTransaction()
//                .replace(R.id.id_references, References())
//                .commit() > 0
///*            R.id.action_contact ->true
//            R.id.action_hobbies -> true
//            R.id.action_references -> true*/
//            else -> super.onOptionsItemSelected(item)
//        }

    }
}