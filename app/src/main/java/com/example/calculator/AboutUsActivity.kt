package com.example.calculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class AboutUsActivity : AppCompatActivity() {
    lateinit var list: ListView
    var data: ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_information_layout)
    }

    fun onClickFacebook(view:View){
        Toast.makeText(this, "Opening Facebook", Toast.LENGTH_LONG).show()
        val implicit = Intent(Intent.ACTION_VIEW,
            Uri.parse("http://www.facebook.com"))
        startActivity(implicit)
    }

    fun onClickTwitter(view:View){
        Toast.makeText(this, "Opening Twitter", Toast.LENGTH_LONG).show()
        val implicit = Intent(Intent.ACTION_VIEW,
            Uri.parse("http://www.twitter.com"))
        startActivity(implicit)
    }

    fun onClickYoutube(view:View){
        Toast.makeText(this, "Opening Youtube", Toast.LENGTH_LONG).show()
        val implicit = Intent(Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com"))
        startActivity(implicit)
    }

    fun onClickPlaystore(view:View){
        Toast.makeText(this, "Opening Play Store", Toast.LENGTH_LONG).show()
        val implicit = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://play.google.com"))
        startActivity(implicit)
    }
}

