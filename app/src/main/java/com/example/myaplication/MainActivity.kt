package com.example.myaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myaplication.ui.theme.MyApplicationTheme
import com.teclab.remembapp.ui.screens.PantallaPrincipalRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                PantallaPrincipalRoute()
            }
        }
    }
}
