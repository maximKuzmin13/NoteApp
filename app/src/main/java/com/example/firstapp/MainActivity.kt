package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity :  AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = RecyclerViewFragment()
        val mFragmentTransaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        mFragmentTransaction.add(R.id.fl_content, fragment).commit()
    }

}
