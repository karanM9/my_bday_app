package com.example.jaanubirthday

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class photoGallery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photo_gallery)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // List of images from res/drawable
        val images = listOf(
            R.raw.image1, R.raw.image2, R.raw.image3,
            R.raw.image4, R.raw.image5, R.raw.image6,
            R.raw.image7, R.raw.image8, R.raw.image9,
            R.raw.image10, R.raw.image11, R.raw.image12,
            R.raw.image13,R.raw.image14,R.raw.image15,R.raw.image16,
            R.raw.image17,R.raw.image18,R.raw.image19,R.raw.image20,
            R.raw.image22,R.raw.image21,
        )

        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns
        recyclerView.adapter = ImageAdapter(images)


    }
}