package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HogarEjerciciosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_hogar_ejercicios,
            container,
            false
        )


        val flechaFlexiones: ImageView =
            view.findViewById(R.id.imageView25)


        flechaFlexiones.setOnClickListener {
            val intent = Intent(
                requireActivity(),
                FlexionesActivity::class.java
            )
            startActivity(intent)
        }

        return view
    }
}


