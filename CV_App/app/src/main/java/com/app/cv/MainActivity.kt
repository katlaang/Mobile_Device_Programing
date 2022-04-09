package com.app.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewPager(viewPager)
        setUpIcons()


    }


    private fun setupViewPager(viewPager: ViewPager){ //private method to set up the swipe views
        val  viewPagerAdapter=ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment(), "Home")
        viewPagerAdapter.addFragment(Education(), "Education")
        viewPagerAdapter.addFragment(Skills(), "Skills")
        viewPagerAdapter.addFragment(Work(), "Work")
        viewPagerAdapter.addFragment(Hobbies(), "Hobbies")
        viewPagerAdapter.addFragment(References(), "References")
        viewPagerAdapter.addFragment(Contact(), "Contact")

        viewPager.adapter=viewPagerAdapter
    }

    private fun setUpIcons(){
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.home)

    }
}