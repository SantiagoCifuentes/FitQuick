package com.example.fitquick

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.FragmentTransaction


class FlexionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flexiones_activity)

        // Añade el fragmento HogarFragment
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flexiones_fragment, EjercicioFragment())
        transaction.commit()
    }
}


