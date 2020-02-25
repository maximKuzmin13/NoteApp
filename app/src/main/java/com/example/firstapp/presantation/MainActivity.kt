package com.example.firstapp.presantation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = supportFragmentManager.findFragmentById(R.id.fl_content) ?: RecyclerViewFragment()

        val mFragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        mFragmentTransaction.replace(R.id.fl_content, fragment).commit()
    }
}


