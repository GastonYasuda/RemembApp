package com.teclab.remembapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teclab.remembapp.data.RepositorioRecordatorio
import com.teclab.remembapp.domain.Recordatorio
import com.teclab.remembapp.ui.components.TarjetaRecordatorio
import com.teclab.remembapp.ui.viewmodel.RecordatorioViewModel

@Composable
fun PantallaPrincipalRoute(
    modifier: Modifier = Modifier,
    viewModel: RecordatorioViewModel = RecordatorioViewModel()
) {
    val recordatorios by viewModel.recordatorios.collectAsState()
    PantallaPrincipal(
        recordatorios = recordatorios,
        modifier = modifier,
        onCompletar = { id -> viewModel.marcarComoCompletado(id) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(
    recordatorios: List<Recordatorio>,
    modifier: Modifier = Modifier,
    onCompletar: (Long) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mis Recordatorios") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(recordatorios, key = { it.id }) { recordatorio ->
                TarjetaRecordatorio(
                    recordatorio = recordatorio,
                    onCompletar = { onCompletar(recordatorio.id) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PantallaPrincipalPreview() {
    MaterialTheme {
        PantallaPrincipal(
            recordatorios = RepositorioRecordatorio.obtenerRecordatorios()
        )
    }
}
