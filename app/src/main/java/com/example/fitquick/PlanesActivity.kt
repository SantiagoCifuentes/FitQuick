package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class PlanesActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.planes) //
        val tituloPantalla = intent.getStringExtra("TITULO_PANTALLA")
        val imagenHogar: ImageView = findViewById(R.id.ImgHogar)
        val imgHogarPesas: ImageView = findViewById(R.id.ImgHogarPesas)
        textView = findViewById(R.id.textViewPlanes)
        textView.text = "$tituloPantalla "



        imagenHogar.setOnClickListener {
            val intent = Intent(this, HogarActivity::class.java)
            startActivity(intent)
        }

        imgHogarPesas.setOnClickListener {
            val intent = Intent(this, HogarPesasActivity::class.java)
            startActivity(intent)
        }

    }

}
