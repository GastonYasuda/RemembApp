package com.teclab.remembapp.domain

import androidx.compose.ui.graphics.Color

/*
- Creo las sealed class para las prioridades, estados y categorias
 */

sealed class Prioridad {
    data object Baja : Prioridad()
    data object Media : Prioridad()
    data object Alta : Prioridad()
}

typealias Prioridades = Prioridad

sealed class Estados {
    data object Completado : Estados()
    data object Pendiente : Estados()
}

sealed class Categorias {
    data object Perro : Categorias()
    data object Compras : Categorias()
    data object Pagos : Categorias()
    data object Hogar : Categorias()
    data object Trabajo : Categorias()
    data object Estudio : Categorias()
    data object Otros : Categorias()
}

fun obtenerColorPorCategoria(categoria: Categorias): Color {
    return when (categoria) {
        Categorias.Perro -> Color(0xFFE53935)   // Rojo
        Categorias.Compras -> Color(0xFF43A047) // Verde
        Categorias.Pagos -> Color(0xFF1E88E5)   // Azul
        Categorias.Hogar -> Color(0xFFFB8C00)   // Naranja
        Categorias.Trabajo -> Color(0xFF8E24AA) // Morado
        Categorias.Estudio -> Color(0xFF00ACC1) // Cían
        Categorias.Otros -> Color(0xFF6D4C41)   // Marrón
    }
}

fun obtenerColorPorCategoria(categoria: String): String {
    return when (categoria.uppercase()) {
        "TECNOLOGIA" -> "#3498db"
        "DEPORTES" -> "#2ecc71"
        "CULTURA" -> "#9b59b6"
        "FINANZAS" -> "#f1c40f"
        else -> "#ffffff" // Color por defecto si no coincide
    }
}

fun mostrarPrioridad(prioridad: Prioridad): String = when (prioridad) {
    Prioridad.Baja -> "Baja"
    Prioridad.Media -> "Media"
    Prioridad.Alta -> "Alta"
}

fun mostrarEstado(estado: Estados): String = when (estado) {
    Estados.Completado -> "Completado"
    Estados.Pendiente -> "Pendiente"
}

fun mostrarCategoria(categoria: Categorias): String = when (categoria) {
    Categorias.Perro -> "Perro"
    Categorias.Compras -> "Compras"
    Categorias.Pagos -> "Pagos"
    Categorias.Hogar -> "Hogar"
    Categorias.Trabajo -> "Trabajo"
    Categorias.Estudio -> "Estudio"
    Categorias.Otros -> "Otros"
}
