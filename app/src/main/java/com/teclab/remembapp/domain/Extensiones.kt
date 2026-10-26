package com.teclab.remembapp.domain

/*
- Crear funcion para los realizados y no realizados
 */

fun Recordatorio.noRealizado(): Boolean =!realizado

fun Recordatorio.realizado(): Recordatorio =
    copy(realizado = true)

