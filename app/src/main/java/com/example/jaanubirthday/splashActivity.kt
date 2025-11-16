package com.example.jaanubirthday

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView

class splashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        val lottieAnimation = findViewById<LottieAnimationView>(R.id.lottieAnimationView)

        // Play animation
        lottieAnimation.playAnimation()

        // Delay for the animation duration before opening MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close SplashActivity so user can't go back to it
        }, 6000) // Change 6000 to the animation duration in milliseconds

        val toast = Toast.makeText(this, "\t\tfrom Karan\t\t\n  Made with ❤️", Toast.LENGTH_LONG)
        toast.view = toast.view
        toast.show()
    }
}