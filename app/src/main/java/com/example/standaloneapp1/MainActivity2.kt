package com.example.standaloneapp1

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.standaloneapp1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

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