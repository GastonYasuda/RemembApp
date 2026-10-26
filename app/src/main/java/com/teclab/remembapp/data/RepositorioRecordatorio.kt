package com.teclab.remembapp.data

import com.teclab.remembapp.domain.Categorias
import com.teclab.remembapp.domain.Prioridad
import com.teclab.remembapp.domain.Recordatorio

object RepositorioRecordatorio {
    private val lista = mutableListOf(
        Recordatorio(1, "Sacar al perro", false, Prioridad.Media, setOf(Categorias.Perro)),
        Recordatorio(2, "Comprar chocolate", false, Prioridad.Baja, setOf(Categorias.Compras)),
        Recordatorio(3, "Pagar la factura AYSA", false, Prioridad.Alta, setOf(Categorias.Pagos)),
        Recordatorio(4, "Limpiar el horno", false, Prioridad.Media, setOf(Categorias.Hogar)),
        Recordatorio(5, "Hacer App del clima", false, Prioridad.Alta, setOf(Categorias.Trabajo)),
    )

    fun obtenerRecordatorios(): List<Recordatorio> = lista.toList()

    fun completar(id: Long) {
        val index = lista.indexOfFirst { it.id == id }
        if (index != -1) {
            lista[index] = lista[index].copy(realizado = true)
        }
    }
}

val recordatorios: List<Recordatorio> get() = RepositorioRecordatorio.obtenerRecordatorios()
