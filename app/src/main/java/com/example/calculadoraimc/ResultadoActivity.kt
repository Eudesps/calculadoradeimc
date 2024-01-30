package com.example.calculadoraimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var pesoInformadoResultado: TextView
    private lateinit var alturaInformadoResultado: TextView
    private lateinit var textoDiagnostico: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        iniciandoComponentesDeTexto()
        val bundle = intent.extras
        //Adquirindo o texto peso e convertendo esse texto para um número Double
        val pesoDoubleEnd = bundle?.getDouble("peso", 0.0)
        pesoInformadoResultado.text = "Peso informado $pesoDoubleEnd"

        //Adquirindo o texto altura e convertendo esse texto para um número Double
        val alturaDoubleEnd = bundle?.getDouble("altura", 0.0)
        alturaInformadoResultado.text = "Altura informado $alturaDoubleEnd"

        /*Calculando através de um método o IMC, passando como parâmetros o peso e altura
        convertidos a cima*/
        val resultado = calcularIMC(pesoDoubleEnd, alturaDoubleEnd)
        val diagnostico = identificarDiagnostico(resultado)
        textoDiagnostico.text = diagnostico
    }

    //Aqui será dado o diagnóstico baseado no resultado do imc
    private fun identificarDiagnostico(resultadoIMC: Double?): String {
        if (resultadoIMC != null) {
            if (resultadoIMC < 18.5) {
                return "Baixo"
            } else if (resultadoIMC in 18.5..24.9) {
                return "Normal"
            } else if (resultadoIMC in 25.0..29.9) {
                return "Sobrepeso"
            } else if (resultadoIMC in 30.0..39.9) {
                return "Obesidade"
            }
        }
        return ""
    }

    // FORMULA PARA CALCULAR = IMC = peso / (altura x altura).
    private fun calcularIMC(peso: Double?, altura: Double?): Double? {
        return peso?.div(((altura?.times(altura)!!)))
    }

    private fun iniciandoComponentesDeTexto() {
        pesoInformadoResultado = findViewById(R.id.text_peso_informado)
        alturaInformadoResultado = findViewById(R.id.text_altura_informado)
        textoDiagnostico = findViewById(R.id.text_resultado)

    }
}