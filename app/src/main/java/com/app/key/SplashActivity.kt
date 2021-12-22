package com.app.key

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR, WindowManager.LayoutParams.TYPE_STATUS_BAR)
        supportActionBar?.hide()

        splash()
        glide()
    }
    fun splash(){
        val intent = Intent(this,MainActivity::class.java)

        Handler().postDelayed({
            intent.change()
        },4000)
    }

    fun Intent.change(){
        startActivity(this)
        finish()
    }

    fun glide(){
        val Gif:ImageView = findViewById(R.id.gif)

        Glide
            .with(this)
            .asGif()
            .load(R.drawable.gif_robo)
            .into(Gif)
    }
}