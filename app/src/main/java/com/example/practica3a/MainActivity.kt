package com.example.practica3a

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.practica3a.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btMostrar.setOnClickListener() { mostrarNombre() }
        binding.btSnackAccion.setOnClickListener() {
            mostrarSnackBarConAccion()
        }
    }

    private fun mostrarNombre() {
        if (binding.etNombre.text.toString().isEmpty()) {
            Toast.makeText(this, "Texto vacío", Toast.LENGTH_SHORT).show()
        } else {
            if (binding.swSnackBar.isChecked()) {
                // layoutActividad es el id del Layout en el xml.
                Snackbar.make(
                    binding.layoutActividad, binding.etNombre.text,
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this, binding.etNombre.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun mostrarSnackBarConAccion() {
        // Cambiamos el color de fondo del layout
        binding.layoutActividad.setBackgroundColor(Color.YELLOW)
        val snackbar: Snackbar
        snackbar =
            Snackbar.make(binding.layoutActividad, "Mi SnackBar con acción!", Snackbar.LENGTH_LONG)
        // Creamos la acción con nombre y código a ejecutar
        snackbar.setAction("Deshacer") {
            // Acciones al pulsar el botón "Deshacer"
            binding.layoutActividad.setBackgroundColor(Color.WHITE)
            // Mostramos el Snackbar
            snackbar.show()
        }
    }
}
