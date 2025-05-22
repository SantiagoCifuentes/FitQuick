package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.principal)

        // Aquí el listener para imageView6 que abre PesasActivity
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

class PesasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pesas_ejercicios)
    }

    class PesasActivityEje : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_pesas)
        }

        class PesasCalenActivity : ComponentActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.fragment_ejercicio2)
            }

            class PesasActivity : ComponentActivity() {
                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.fragment_pesas_ejercicios)

                    // Click en iconOneDay -> abre PesasCalenActivity
                    val iconOneDay = findViewById<ImageView>(R.id.iconOneDay)
                    iconOneDay.setOnClickListener {
                        val intent = Intent(this, PesasCalenActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

        }
    }
}