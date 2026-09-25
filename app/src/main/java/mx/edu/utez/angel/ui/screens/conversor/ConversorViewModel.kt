package mx.edu.utez.angel.ui.screens.conversor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ConversorViewModel : ViewModel() {

    // Constante de negocio
    private val TIPO_CAMBIO = 18.00

    // Estados observables por la Vista
    var usdInput by mutableStateOf("")
        private set // Solo el ViewModel puede modificar este texto directamente

    var resultadoMxn by mutableStateOf(0.0)
        private set

    // Eventos invocados desde la Vista
    fun onUsdInputChanged(nuevoTexto: String) {
        usdInput = nuevoTexto
    }

    fun convertirDivisa() {
        val dolares = usdInput.toDoubleOrNull() ?: 0.0
        resultadoMxn = dolares * TIPO_CAMBIO
    }
}