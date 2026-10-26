package com.teclab.remembapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teclab.remembapp.domain.Categorias
import com.teclab.remembapp.domain.Prioridad
import com.teclab.remembapp.domain.Recordatorio
import com.teclab.remembapp.domain.mostrarCategoria
import com.teclab.remembapp.domain.mostrarPrioridad
import com.teclab.remembapp.domain.obtenerColorPorCategoria

@Composable
fun TarjetaRecordatorio(
    recordatorio: Recordatorio,
    modifier: Modifier = Modifier,
    onCompletar: () -> Unit = {}
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Título
            Text(
                text = recordatorio.titulo ?: "",
                style = MaterialTheme.typography.titleMedium
            )

            // Estado y Prioridad en texto
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (recordatorio.realizado) "Estado: Realizado" else "Estado: Pendiente",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )

                Text(
                    text = "Prioridad: ${mostrarPrioridad(recordatorio.prioridad)}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = when (recordatorio.prioridad) {
                        Prioridad.Alta -> Color(0xFFD32F2F)
                        Prioridad.Media -> Color(0xFFF57C00)
                        Prioridad.Baja -> Color(0xFF388E3C)
                    }
                )
            }

            // Categorías con un color diferente por cada una
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                recordatorio.categoria.forEach { cat ->
                    Surface(
                        color = obtenerColorPorCategoria(cat),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = mostrarCategoria(cat),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TarjetaRecordatorioPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TarjetaRecordatorio(
                recordatorio = Recordatorio(
                    id = 1,
                    titulo = "Sacar al perro",
                    realizado = false,
                    prioridad = Prioridad.Media,
                    categoria = setOf(Categorias.Perro)
                )
            )
            TarjetaRecordatorio(
                recordatorio = Recordatorio(
                    id = 2,
                    titulo = "Comprar chocolate",
                    realizado = false,
                    prioridad = Prioridad.Alta,
                    categoria = setOf(Categorias.Compras)
                )
            )
        }
    }
}
