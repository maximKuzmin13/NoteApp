package com.example.firstapp

import RecyclerViewFragment
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val fragment = RecyclerViewFragment()
        val mFragmentTransaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        mFragmentTransaction.add(R.id.fl_content, fragment).commit()
    }
}
