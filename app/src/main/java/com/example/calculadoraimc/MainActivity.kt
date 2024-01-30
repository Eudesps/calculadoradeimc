package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalcular: Button
    private lateinit var textPeso: TextInputEditText
    private lateinit var textAltura: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializandoComponentesDeTexto()
        btnCalcular = findViewById(R.id.btn_calcular)
        btnCalcular.setOnClickListener {
            val pesoString = textPeso.text.toString()
            val pesoDoubleFinal = pesoString.toDouble()

            val alturaString = textAltura.text.toString()
            val alturaDoubleFinal = alturaString.toDouble()

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("peso", pesoDoubleFinal)
            intent.putExtra("altura", alturaDoubleFinal)
            startActivity(intent)
        }
    }

    private fun inicializandoComponentesDeTexto() {
        textPeso = findViewById(R.id.edit_peso)
        textAltura = findViewById(R.id.edit_altura)
    }
}