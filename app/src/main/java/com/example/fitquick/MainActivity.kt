package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.principal)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.nav_ejercicios -> {
                    // Quedarse en la misma pantalla (MainActivity)
                    true
                }

                R.id.nav_planes -> {
                    // Ir a la pantalla de "PlanesActivity"
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





