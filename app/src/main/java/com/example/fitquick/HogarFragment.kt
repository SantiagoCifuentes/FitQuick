package com.example.fitquick

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class HogarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hogar, container, false)

        val iconOneDay: ImageView = view.findViewById(R.id.iconOneDay)
        iconOneDay.setOnClickListener {
            val intent = Intent(activity, FlexionesActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}
