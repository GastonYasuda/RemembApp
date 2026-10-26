package com.teclab.remembapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.teclab.remembapp.data.RepositorioRecordatorio
import com.teclab.remembapp.domain.Recordatorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecordatorioViewModel(
    private val repositorio: RepositorioRecordatorio = RepositorioRecordatorio
) : ViewModel() {

    private val _recordatorios = MutableStateFlow<List<Recordatorio>>(emptyList())
    val recordatorios: StateFlow<List<Recordatorio>> = _recordatorios.asStateFlow()

    init {
        cargarRecordatorios()
    }

    fun cargarRecordatorios() {
        _recordatorios.value = repositorio.obtenerRecordatorios()
    }

    fun marcarComoCompletado(id: Long) {
        repositorio.completar(id)
        cargarRecordatorios()
    }
}
