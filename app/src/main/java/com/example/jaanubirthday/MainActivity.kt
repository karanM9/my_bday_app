package com.example.jaanubirthday

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val blinkingClickHere = findViewById<TextView>(R.id.blinkingClickHere)
        val balloonClick = findViewById<ImageView>(R.id.balloonClick)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val hugsText = findViewById<TextView>(R.id.hugsText)
        var hugsSending = findViewById<TextView>(R.id.hugsSending)
        val hugButton = findViewById<Button>(R.id.hugButton)

        blinkingClickHere.visibility = View.INVISIBLE
        hugsSending.visibility = View.GONE

        // Ensure the ImageView is clickable
        balloonClick.isClickable = true
        balloonClick.setOnClickListener {
            Toast.makeText( this,"Welcome Jaanu", Toast.LENGTH_SHORT).show()
            val buttonChoice = Intent(this, ButtonChoice::class.java)
            startActivity(buttonChoice)

        }
        // Start animation
        hugButton.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                hugButton.visibility = Button.GONE
                progressBar.visibility = ProgressBar.VISIBLE // Show progress bar
                hugsSending.visibility = View.VISIBLE

                // Animate progress to 100%
                val animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100)
                animator.duration = 5000 // 5 seconds to fill up
                animator.start()

                Handler(Looper.getMainLooper()).postDelayed({
                    hugsText.visibility = TextView.VISIBLE
                    blinkingClickHere.visibility = View.VISIBLE// Show text message
                    hugsSending.text = " Hugs Sent..."
                    hugsSending.visibility = View.VISIBLE
                    progressBar.visibility = ProgressBar.VISIBLE
                }, 5000) // Show message after progress completes
            }, 800)
        }


        // After progress completes, show message
        startBlinking(blinkingClickHere)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun startBlinking(blinkingClickHere: TextView) {
        val color1 = Color.parseColor("#ffb3ae")
        val color2 = Color.parseColor("#6A1452")

        val animator = ValueAnimator.ofObject(ArgbEvaluator(), color1, color2)
        animator.duration = 1000 // Duration of each transition in milliseconds
        animator.repeatCount = ValueAnimator.INFINITE // Infinite loop
        animator.repeatMode = ValueAnimator.REVERSE // Reverse the animation to go back to the original color

        // Apply the color change to the TextView
        animator.addUpdateListener { animation ->
            blinkingClickHere.setTextColor(animation.animatedValue as Int)

        }

        animator.start()
    }
}