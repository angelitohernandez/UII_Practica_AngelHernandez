package mx.edu.utez.angel.ui.screens.propinas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PropinasViewModel : ViewModel() {

    // Estado del monto ingresado
    var montoCuentaInput by mutableStateOf("")
        private set

    // Porcentaje de propina por defecto (10%, 15%, 20%)
    var porcentajePropina by mutableDoubleStateOf(15.0)
        private set

    // Resultados calculados
    var propinaCalculada by mutableDoubleStateOf(0.0)
        private set

    var totalPagar by mutableDoubleStateOf(0.0)
        private set

    // Modificadores de estado
    fun onMontoCuentaChanged(nuevoMonto: String) {
        montoCuentaInput = nuevoMonto
        recalcularValores()
    }

    fun onPorcentajeChanged(nuevoPorcentaje: Double) {
        porcentajePropina = nuevoPorcentaje
        recalcularValores()
    }

    private fun recalcularValores() {
        val cuenta = montoCuentaInput.toDoubleOrNull() ?: 0.0

        // Evitamos valores negativos
        val cuentaValida = if (cuenta < 0) 0.0 else cuenta

        propinaCalculada = cuentaValida * (porcentajePropina / 100.0)
        totalPagar = cuentaValida + propinaCalculada
    }
}