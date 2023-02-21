package com.example.standaloneapp1

import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat

import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var cameraBtn:Button
    private lateinit var submitButton:Button
    private lateinit var image:ImageView
    private lateinit var first:TextView
    private lateinit var middle:TextView
    private lateinit var last:TextView
    private lateinit var imagebitmap:Bitmap
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cameraBtn = findViewById<Button>(R.id.button)
        image = findViewById(R.id.imageView)
        first = findViewById(R.id.first_text_input)
        middle = findViewById(R.id.middle_text_input)
        last = findViewById(R.id.last_text_input)
        submitButton = findViewById<Button>(R.id.button2)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),111)

        }
        else{
            cameraBtn.isEnabled = true
        }
        cameraBtn.setOnClickListener {

            var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 101)

        }
        submitButton.setOnClickListener {
            if(checkFirstText() && checkMiddleText() && checkLastText() && imagebitmap != null){
                var intent = Intent(this, MainActivity2::class.java)
                val bundle = Bundle()
                bundle.putString("first", first.text.toString())
                bundle.putString("middle", middle.text.toString())
                bundle.putString("last", last.text.toString())
                bundle.putParcelable("image", imagebitmap)

                intent.putExtras(bundle)
                startActivity(intent)
            }

        }


    }
    fun checkFirstText(): Boolean {
        return first.text != null && first.text.toString() != ""
    }
    fun checkMiddleText(): Boolean {
        return middle.text != null && middle.text.toString() != ""
    }
    fun checkLastText(): Boolean {
        return last.text != null && last.text.toString() != ""
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101){
            var pic = data!!.getParcelableExtra<Bitmap>("data")
            image.setImageBitmap(pic)
            imagebitmap = pic!!

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            cameraBtn.isEnabled = true
        }

    }

}