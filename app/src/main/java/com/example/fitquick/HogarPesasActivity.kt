package com.example.fitquick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class HogarPesasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hogar_activity)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_pesas, PesasFragment())
            .commit()
    }
}
