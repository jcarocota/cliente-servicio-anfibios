package com.ebc.cliente_servicio_anfibios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ebc.cliente_servicio_anfibios.ui.components.HomeScreen
import com.ebc.cliente_servicio_anfibios.ui.theme.ClienteservicioanfibiosTheme
import com.ebc.cliente_servicio_anfibios.viewmodels.AnfibiosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClienteservicioanfibiosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val anfibiosViewModel:AnfibiosViewModel =
                        viewModel(factory = AnfibiosViewModel.Factory)
                    HomeScreen(
                        anfibioUiState = anfibiosViewModel.amphibiansUiState,
                        retryAction = anfibiosViewModel::getAnfibios,
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClienteservicioanfibiosTheme {
        Greeting("Android")
    }
}