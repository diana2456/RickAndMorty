package com.example.rickandmorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmorty.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragment()
        setContentView(R.layout.activity_main)
    }
    fun fragment(){
        supportFragmentManager.beginTransaction().add(R.id.container, FragmentList()).commit()
    }
    }



