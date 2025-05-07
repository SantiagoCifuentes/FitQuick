import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fitquick.R

class EjercicioFragment : Fragment() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var db: SQLiteDatabase

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
        val tableLayout = view.findViewById<TableLayout>(R.id.table_layout)
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
            }
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
