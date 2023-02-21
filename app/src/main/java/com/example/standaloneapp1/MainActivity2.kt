package com.example.standaloneapp1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {


    private lateinit var firstNameTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        firstNameTextView = findViewById(R.id.loggedInTextView)

        val firstText = intent.getStringExtra("first")
        val lastText = intent.getStringExtra("last")
        val statement = "$firstText $lastText is logged in!"
        firstNameTextView.text = statement

    }

}