package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

class SettingsActivity : AppCompatActivity() {
    lateinit var list: ListView
    var data : ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        //init views
        list = findViewById(R.id.list)

        //init data
        data.add("User Policy")
        data.add("Private Policy")
        list.adapter = ArrayAdapter<String>(this, R.layout.my_row_layout, data)
    }

}