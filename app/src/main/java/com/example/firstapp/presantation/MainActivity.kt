package com.example.firstapp.presantation

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.firstapp.R
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
