package mx.edu.utez.angel.ui.screens.amigos

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Amigo(
    val id: Int,
    val nombreCompleto: String,
    val edad: Int,
    val fechaNacimiento: String,
    val esMejorAmigo: Boolean = false
)

class AmigosViewModel : ViewModel() {

    // Estado interno mutable
    private val _elementos = MutableStateFlow<List<Amigo>>(emptyList())
    // Estado público de solo lectura
    val elementos: StateFlow<List<Amigo>> = _elementos.asStateFlow()

    init {
        val amigo1 = Amigo(id = 1, nombreCompleto = "Sebastian Martinez", edad = 19, fechaNacimiento = "09/08/07", esMejorAmigo = true)
        val amigo2 = Amigo(id = 2, nombreCompleto = "Miguel Chavez", edad = 20, fechaNacimiento = "26/09/26", esMejorAmigo = true)
        val amigo3 = Amigo(id = 3, nombreCompleto = "Gerardo Barron", edad = 19, fechaNacimiento = "05/01/07", esMejorAmigo = true)
        val amigo4 = Amigo(id = 4, nombreCompleto = "Josue Hernandez", edad = 19, fechaNacimiento = "22/10/07", esMejorAmigo = true)
        val amigo5 = Amigo(id = 5, nombreCompleto = "Josue Pantaleon", edad = 20, fechaNacimiento = "23/09/06", esMejorAmigo = true)

        _elementos.value = listOf(amigo1, amigo2, amigo3, amigo4, amigo5)
    }

    fun actualizarMejorAmigo(id: Int) {
        _elementos.update { listaActual ->
            listaActual.map { item ->
                if (item.id == id) {
                    item.copy(esMejorAmigo = !item.esMejorAmigo)
                } else {
                    item
                }
            }
        }
    }
}