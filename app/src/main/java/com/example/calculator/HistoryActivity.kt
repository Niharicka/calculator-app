package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.view.*

class HistoryActivity : AppCompatActivity() {
    lateinit var list: ListView
    lateinit var data:ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_activity)

        data = intent.extras.getStringArrayList("data")

        //init views
        list = findViewById(R.id.list)
        adapter = ArrayAdapter<String>(this,R.layout.my_row_layout,data)
        list.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        var inflater: MenuInflater = getMenuInflater()
        inflater.inflate(R.menu.menu_history_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.buttondelete -> {
                data.clear()
                adapter.notifyDataSetChanged()
                setResult(99)
            }
            else ->
                return false
        }
        return super.onOptionsItemSelected(item)
    }
}