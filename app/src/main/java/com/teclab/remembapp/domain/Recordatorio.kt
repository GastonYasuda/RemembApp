package com.teclab.remembapp.domain

data class Recordatorio(
    val id: Long,
    val titulo: String? = null,
    val realizado: Boolean,
    val prioridad: Prioridad,
    val categoria: Set<Categorias>,
) {
    val categorias: Set<Categorias> get() = categoria
}
