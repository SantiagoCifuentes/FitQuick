package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity

class PesasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pesas_ejercicios)

        val imageView25 = findViewById<ImageView>(R.id.imageView25)
        imageView25.setOnClickListener {
            val intent = Intent(this, PesasActivityEje::class.java)
            startActivity(intent)
        }
    }
}
