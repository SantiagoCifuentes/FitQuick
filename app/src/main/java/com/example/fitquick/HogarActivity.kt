package com.example.fitquick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class HogarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hogar_activity) // Asegúrate de que el nombre del layout sea correcto

        // Añade el fragmento HogarFragment
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.hogar_fragment, HogarFragment())
        transaction.commit()
    }
}