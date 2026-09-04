package com.miempresa.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.miempresa.exploracioncomponentes.ui.theme.ExploracionComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploracionComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        // Puedes alternar estas funciones para ver distintos grupos
                        ContenedoresScreen()
                        Spacer(modifier = Modifier.height(16.dp))
                        ControlesUnoScreen()
                        Spacer(modifier = Modifier.height(16.dp))
                        ControlesDosScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun ContenedoresScreen() {
    Column {
        Text("--- Contenedores ---", style = MaterialTheme.typography.titleMedium)
        ScaffoldEjemplo()
        LazyRowEjemplo()
        LazyColumnEjemplo()
    }
}

@Composable
fun ScaffoldEjemplo() {
    Card(modifier = Modifier.padding(vertical = 8.dp)) {
        Text("Ejemplo de Scaffold (Simulado)", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun LazyColumnEjemplo() {
    Text("LazyColumn (Vertical):")
    LazyColumn(modifier = Modifier.height(100.dp)) {
        items(5) { Text("  Item Vertical $it", modifier = Modifier.padding(4.dp)) }
    }
}

@Composable
fun LazyRowEjemplo() {
    Text("LazyRow (Horizontal):")
    LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
        items(5) { Text(" [Item $it] ", modifier = Modifier.padding(4.dp)) }
    }
}

@Composable
fun ControlesUnoScreen() {
    Column {
        Text("--- Controles I ---", style = MaterialTheme.typography.titleMedium)
        AlertDialogEjemplo()
        CardEjemplo()
    }
}

@Composable
fun AlertDialogEjemplo() {
    var openDialog by remember { mutableStateOf(false) }

    Button(
        onClick = { openDialog = true },
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text("Mostrar Alerta")
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = { openDialog = false },
            title = { Text("Título") },
            text = { Text("Este es un mensaje de alerta.") },
            confirmButton = {
                Button(onClick = { openDialog = false }) { Text("OK") }
            }
        )
    }
}

@Composable
fun CardEjemplo() {
    Card(
        modifier = Modifier.padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text("Contenido de la tarjeta", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ControlesDosScreen() {
    Column {
        Text("--- Controles II ---", style = MaterialTheme.typography.titleMedium)
        OutlinedTextFieldEjemplo()
    }
}

@Composable
fun OutlinedTextFieldEjemplo() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") },
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewsLaboratorio() {
    ExploracionComponentesTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            ContenedoresScreen()
            ControlesUnoScreen()
            ControlesDosScreen()
        }
    }
}
