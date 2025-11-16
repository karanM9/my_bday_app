package com.example.jaanubirthday

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class sorryText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sorry_text)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // List of images from res/drawable
        val images = listOf(
            R.raw.princess1, R.raw.princess2, R.raw.princess3,
            R.raw.princess4, R.raw.princess5, R.raw.princess6,
            R.raw.princess7, R.raw.princess8, R.raw.princess9,
            R.raw.princess10, R.raw.princess11, R.raw.princess12,
            R.raw.princess13,R.raw.princess14,R.raw.princess15,R.raw.princess16,
            R.raw.princess17,R.raw.princess18,R.raw.princess19,R.raw.princess20,
        )

        recyclerView.layoutManager = GridLayoutManager(this, 1) // 2 columns
        recyclerView.adapter = ImageAdapter(images)
        }
    }
