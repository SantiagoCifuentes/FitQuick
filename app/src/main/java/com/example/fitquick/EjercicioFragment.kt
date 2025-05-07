import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fitquick.R

class EjercicioFragment : Fragment() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var tableLayout: TableLayout

    companion object {
        private const val DATABASE_NAME = "workout.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "workout"
        const val COLUMN_ID = "id"
        const val COLUMN_REPS = "reps"
        const val COLUMN_WEIGHT = "weight"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ejercicio, container, false)

        dbHelper = DatabaseHelper(requireContext())
        db = dbHelper.writableDatabase

        val weightInput = view.findViewById<EditText>(R.id.etPeso)
        val repsInput = view.findViewById<EditText>(R.id.etReps)
        val saveButton = view.findViewById<Button>(R.id.btnAdd)
        val clearButton = view.findViewById<Button>(R.id.btnClear)
        tableLayout = view.findViewById<TableLayout>(R.id.table_layout)
        val weightTextView = view.findViewById<TextView>(R.id.weight_text_view)
        val repsTextView = view.findViewById<TextView>(R.id.reps_text_view)

        tableLayout.visibility = View.GONE

        saveButton.setOnClickListener {
            val weight = weightInput.text.toString()
            val reps = repsInput.text.toString()

            if (weight.isNotEmpty() && reps.isNotEmpty()) {
                insertWorkout(reps.toInt(), weight.toFloat())

                weightTextView.text = weight
                repsTextView.text = reps
                tableLayout.visibility = View.VISIBLE

                displayWorkouts()  // Llamar a displayWorkouts para mostrar los datos guardados
            }
        }

        clearButton.setOnClickListener {
            deleteAllWorkouts()  // Borrar todos los registros
            tableLayout.visibility = View.GONE
        }

        return view
    }

    private fun insertWorkout(reps: Int, weight: Float) {
        val values = ContentValues().apply {
            put(COLUMN_REPS, reps)
            put(COLUMN_WEIGHT, weight)
        }
        db.insert(TABLE_NAME, null, values)
    }

    private fun deleteAllWorkouts() {
        db.delete(TABLE_NAME, null, null)
    }

    private fun getAllWorkouts(): List<Pair<Int, Float>> {
        val workouts = mutableListOf<Pair<Int, Float>>()
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(COLUMN_REPS, COLUMN_WEIGHT),
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val reps = getInt(getColumnIndexOrThrow(COLUMN_REPS))
                val weight = getFloat(getColumnIndexOrThrow(COLUMN_WEIGHT))
                workouts.add(Pair(reps, weight))
            }
        }
        cursor.close()
        return workouts
    }

    private fun displayWorkouts() {
        val workouts = getAllWorkouts()
        tableLayout.removeAllViews()  // Limpiar todas las filas antes de agregar nuevas

        // Agregar encabezados de la tabla
        val headerRow = TableRow(requireContext())
        val headerReps = TextView(requireContext())
        val headerWeight = TextView(requireContext())
        headerReps.text = "REPETICIONES"
        headerWeight.text = "PESO (LBS)"
        headerReps.setPadding(8, 8, 8, 8)
        headerWeight.setPadding(8, 8, 8, 8)
        headerReps.setBackgroundColor(resources.getColor(R.color.white))
        headerWeight.setBackgroundColor(resources.getColor(R.color.white))
        headerReps.setTextColor(resources.getColor(R.color.orange))
        headerWeight.setTextColor(resources.getColor(R.color.orange))
        headerReps.setTypeface(null, Typeface.BOLD)
        headerWeight.setTypeface(null, Typeface.BOLD)
        headerRow.addView(headerReps)
        headerRow.addView(headerWeight)
        tableLayout.addView(headerRow)

        // Agregar filas para cada registro
        for ((reps, weight) in workouts) {
            val row = TableRow(requireContext())
            val repsTextView = TextView(requireContext())
            val weightTextView = TextView(requireContext())

            repsTextView.text = reps.toString()
            weightTextView.text = weight.toString()
            repsTextView.setPadding(8, 8, 8, 8)
            weightTextView.setPadding(8, 8, 8, 8)
            repsTextView.setBackgroundColor(resources.getColor(R.color.orange))
            weightTextView.setBackgroundColor(resources.getColor(R.color.orange))
            repsTextView.setTextColor(resources.getColor(R.color.white))
            weightTextView.setTextColor(resources.getColor(R.color.white))

            row.addView(repsTextView)
            row.addView(weightTextView)
            tableLayout.addView(row)
        }
    }

    inner class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        override fun onCreate(db: SQLiteDatabase) {
            val createTable = ("CREATE TABLE $TABLE_NAME ("
                    + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "$COLUMN_REPS INTEGER, "
                    + "$COLUMN_WEIGHT REAL)")
            db.execSQL(createTable)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }
}
