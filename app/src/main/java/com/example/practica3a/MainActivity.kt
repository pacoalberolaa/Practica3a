package com.example.practica3a

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.practica3a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Estas dos líneas sustituyen a
//setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            var message: String = ""
            if (binding.editText.text.isEmpty() ||
                binding.editTextNumber.text.isEmpty()
            ) {
                message = "Hay algún texto vacío..."
                binding.textView.text = ""
            } else {
                message = "Texto: " + binding.editText.text.toString() +
                        "\nNúmero: " + binding.editTextNumber.text.toString()
                binding.textView.text = message
                Toast.makeText(
                    applicationContext,
                    message,
                    Toast.LENGTH_SHORT
                ).show()

                ocultarTeclado(it)

                binding.floatingActionButton.setOnClickListener {
                    Toast.makeText(applicationContext, "Pulsamos el botón flotante",
                        Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    fun ocultarTeclado(view: View?) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as
                InputMethodManager
        if (view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}
