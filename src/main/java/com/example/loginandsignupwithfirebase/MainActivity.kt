package com.example.loginandsignupwithfirebase

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginandsignupwithfirebase.databinding.ActivityMainBinding
import com.example.loginandsignupwithfirebase.databinding.ActivityWelcomeScreenBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.createNotebutton.setOnClickListener {

            startActivity(Intent(this, AddNote::class.java))



        }
        binding.openNotebutton.setOnClickListener {

            startActivity(Intent(this, AllNotes::class.java))



        }





    }
}