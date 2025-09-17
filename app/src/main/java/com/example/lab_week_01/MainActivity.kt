package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // biar inset (status bar dsb) tidak nutup UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi view
        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        // Listener tombol
        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)
                ?.text.toString().trim()
            val studentNumber = findViewById<TextInputEditText>(R.id.student_number_input)
                ?.text.toString().trim()

            if (nameInput.isEmpty()) {
                // Jika nama kosong
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
            } else if (studentNumber.length != 11) {
                // Jika student number bukan 11 digit
                Toast.makeText(this, "Student number has to be 11 digits long", Toast.LENGTH_LONG).apply {
                    setGravity(Gravity.CENTER, 0, 0)
                    show()
                }
            } else {
                // Jika valid → tampilkan di TextView
                nameDisplay.text =
                    getString(R.string.name_greet) + " " + nameInput +
                            "\nStudent Number: " + studentNumber
            }
        }
    }
}
