package com.example.relojsimple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.relojsimple.ui.theme.RelojSimpleTheme
// import kotlinx.coroutines.delay
// import java.text.SimpleDateFormat
// import java.util.Date
// import java.util.Locale

/**
 * Archivo de base para que los estudiantes implementen un reloj digital.
 *
 * Reemplaza el código generado por defecto en tu MainActivity con este contenido
 * y completa las secciones marcadas con `// TODO` según las consignas del ejercicio.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RelojSimpleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // TODO: llama aquí a la función composable que construirá la pantalla del reloj
                    PantallaReloj()
                }
            }
        }
    }
}

@Composable
fun PantallaReloj() {
    /*
     * TODO:
     * 1. Crear variables de estado para la hora actual (horaActual) y el estilo (estilo).
     *    Usa remember { mutableStateOf(...) }
     * 2. Mostrar la hora actual usando un Text().
     * 3. Actualizar la hora cada segundo dentro de un LaunchedEffect(Unit) con delay(1000).
     * 4. Agregar un Button que al pulsarlo cambie la variable 'estilo' y altere el diseño del reloj.
     * 5. Crear al menos tres estilos distintos utilizando when (estilo) { ... }.
     */
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Reloj con hora fija de ejemplo
        Text(
            text = "10:30:00",
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // TODO: agregar aquí el botón para cambiar de diseño
        Button(onClick = { /* TODO: cambiar la variable de estilo */ }) {
            Text("Cambiar diseño")
        }
    }
}