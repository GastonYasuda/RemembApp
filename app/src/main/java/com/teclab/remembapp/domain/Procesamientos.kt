package com.teclab.remembapp.domain


fun losNoRealizados(recordatorios: List<Recordatorio>): List<Recordatorio> =
    recordatorios.filter { it.noRealizado() }

fun losRealizados(recordatorios: List<Recordatorio>): List<Recordatorio> =
    recordatorios.filter { it.realizado }

fun filtrarPorPrioridad(recordatorios: List<Recordatorio>, prioridad: Prioridades): List<Recordatorio> =
    recordatorios.filter { it.prioridad == prioridad }

fun filtrarPorCategorias(recordatorios: List<Recordatorio>): Set<Categorias> =
    recordatorios.flatMap { it.categoria }.toSet()
