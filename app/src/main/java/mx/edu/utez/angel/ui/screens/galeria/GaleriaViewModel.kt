package mx.edu.utez.angel.ui.screens.galeria
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mx.edu.utez.angel.R

class GaleriaViewModel : ViewModel() {

    private val listaImagenes = listOf(
        R.drawable.imagen1,
        R.drawable.imagen_2,
        R.drawable.imagen_3
    )

    var indiceActual by mutableIntStateOf(0)
        private set

    val imagenActualResId: Int
        get() = if (listaImagenes.isNotEmpty()) listaImagenes[indiceActual] else R.drawable.imagen1

    fun siguienteImagen() {
        if (listaImagenes.isNotEmpty()) {
            indiceActual = (indiceActual + 1) % listaImagenes.size
        }
    }

    fun anteriorImagen() {
        if (listaImagenes.isNotEmpty()) {
            indiceActual = if (indiceActual - 1 < 0) {
                listaImagenes.size - 1
            } else {
                indiceActual - 1
            }
        }
    }
}