package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity

class PesasActivityEje : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pesas)

        val iconOneDay = findViewById<ImageView>(R.id.iconOneDay)
        iconOneDay.setOnClickListener {
            val intent = Intent(this, PesasCalenActivity::class.java)
            startActivity(intent)
        }
    }
}
