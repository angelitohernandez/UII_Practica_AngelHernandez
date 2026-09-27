package mx.edu.utez.angel.ui.screens.amigos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ItemTarjeta(
    item: Amigo,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = if (item.nombreCompleto.isNotBlank()) item.nombreCompleto else "Nombre Completo",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Edad: ${if (item.edad > 0) item.edad else "--"} años",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Nacimiento: ${item.fechaNacimiento.ifBlank { "--/--/----" }}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                imageVector = if (item.esMejorAmigo) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = if (item.esMejorAmigo) "Mejor Amigo" else "No es Mejor Amigo",
                tint = if (item.esMejorAmigo) Color.Red else Color.Gray,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

