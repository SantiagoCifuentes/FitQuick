package com.example.fitquick

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import androidx.core.content.edit


class EjercicioFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ejercicio, container, false)

        val weightInput = view.findViewById<EditText>(R.id.etPeso)
        val repsInput = view.findViewById<EditText>(R.id.etReps)
        val saveButton = view.findViewById<Button>(R.id.btnAdd)
        val tableLayout = view.findViewById<TableLayout>(R.id.table_layout)
        val weightTextView = view.findViewById<TextView>(R.id.weight_text_view)
        val repsTextView = view.findViewById<TextView>(R.id.reps_text_view)


        tableLayout.visibility = View.GONE

        saveButton.setOnClickListener {
            val weight = weightInput.text.toString()
            val reps = repsInput.text.toString()

            if (weight.isNotEmpty() && reps.isNotEmpty()) {
                val prefs = requireActivity().getSharedPreferences("EjercicioFragment", Context.MODE_PRIVATE)
                prefs.edit() {
                    putString("weight", weight)
                    putString("reps", reps)
                }

                weightTextView.text = weight
                repsTextView.text = reps
                tableLayout.visibility = View.VISIBLE
            }
        }

        return view
    }

}