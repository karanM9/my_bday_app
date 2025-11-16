package com.example.jaanubirthday

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ButtonChoice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_button_choice)

        val galley1Button = findViewById<Button>(R.id.gallery1Button)
        val messageButton = findViewById<Button>(R.id.messageButton)
        val gallery2Button = findViewById<Button>(R.id.gallery2Button)

        galley1Button.setOnClickListener() {
            val gallery1Click = Intent(this, photoGallery::class.java)
            startActivity(gallery1Click)
        }

        messageButton.setOnClickListener() {
            val messageClick = Intent(this, messageText::class.java)
            startActivity(messageClick)
        }

        gallery2Button.setOnClickListener() {
            val gallery2Click = Intent(this, sorryText::class.java)
            startActivity(gallery2Click)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}