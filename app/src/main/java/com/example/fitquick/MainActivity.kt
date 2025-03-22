package com.example.fitquick

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitquick.ui.theme.FitQuickTheme
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_ejercicios -> {
                    Toast.makeText(this, "Ejercicios", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_planes -> {
                    Toast.makeText(this, "Planes", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }
}





