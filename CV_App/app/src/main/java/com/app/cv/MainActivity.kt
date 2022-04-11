package com.app.cv

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.menu.MenuBuilder
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewPager(viewPager)
        setUpIcons()


    }


    private fun setupViewPager(viewPager: ViewPager){ //private method to set up the swipe views
        val  viewPagerAdapter=ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment(), "Home")
        viewPagerAdapter.addFragment(Education(), "Education")
        viewPagerAdapter.addFragment(Skills(), "Skills")
        viewPagerAdapter.addFragment(Work(), "Work.kt")
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