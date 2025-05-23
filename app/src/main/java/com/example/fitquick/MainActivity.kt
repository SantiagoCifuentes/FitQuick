// MainActivity.kt
package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)

        val imageView6 = findViewById<ImageView>(R.id.imageView6)
        imageView6.setOnClickListener {
            val intent = Intent(this, PesasActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_ejercicios -> true
                R.id.nav_planes -> {
                    val intent = Intent(this, PlanesActivity::class.java)
                    intent.putExtra("TITULO_PANTALLA", "Bienvenido a Planes")
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}