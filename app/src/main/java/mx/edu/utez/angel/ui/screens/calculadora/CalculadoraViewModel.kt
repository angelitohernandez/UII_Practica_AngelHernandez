package mx.edu.utez.angel.ui.screens.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculadoraViewModel : ViewModel() {

    var pantallaText by mutableStateOf("")
        private set

    private var primerNumero: Double? = null
    private var operacionPendiente: String? = null
    private var nuevoNumeroInicia: Boolean = false

    fun onNumeroClick(numero: String) {
        if (nuevoNumeroInicia) {
            pantallaText = numero
            nuevoNumeroInicia = false
        } else {
            pantallaText += numero
        }
    }

    fun onPuntoClick() {
        if (nuevoNumeroInicia) {
            pantallaText = "0."
            nuevoNumeroInicia = false
        } else if (!pantallaText.contains(".")) {
            pantallaText = if (pantallaText.isEmpty()) "0." else "$pantallaText."
        }
    }

    fun onOperacionClick(operacion: String) {
        val numActual = pantallaText.toDoubleOrNull()
        if (numActual != null) {
            primerNumero = numActual
            operacionPendiente = operacion
            nuevoNumeroInicia = true
        }
    }

    fun onIgualClick() {
        val num2 = pantallaText.toDoubleOrNull()
        val num1 = primerNumero

        if (num1 != null && num2 != null && operacionPendiente != null) {
            val resultado = when (operacionPendiente) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> 0.0
            }

            pantallaText = if (resultado.isNaN()) {
                "Error"
            } else if (resultado % 1 == 0.0) {
                resultado.toLong().toString()
            } else {
                resultado.toString()
            }

            primerNumero = null
            operacionPendiente = null
            nuevoNumeroInicia = true
        }
    }

    fun onClearClick() {
        pantallaText = ""
        primerNumero = null
        operacionPendiente = null
        nuevoNumeroInicia = false
    }
}