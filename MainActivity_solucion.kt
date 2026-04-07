package com.example.relojsimple

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.relojsimple.ui.theme.RelojSimpleTheme
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Solución completa del ejercicio del reloj digital.
 *
 * Esta versión implementa la obtención de la hora actual, la actualización automática
 * cada segundo y un botón para alternar entre tres estilos visuales diferentes.
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
                    PantallaReloj()
                }
            }
        }
    }
}

@Composable
fun PantallaReloj() {
    var horaActual by remember { mutableStateOf(obtenerHoraActual()) }
    var estilo by remember { mutableStateOf(0) }

    // Efecto lanzado al crear la composición para actualizar la hora cada segundo
    LaunchedEffect(Unit) {
        while (true) {
            horaActual = obtenerHoraActual()
            delay(1000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (estilo) {
            0 -> {
                Text(
                    text = horaActual,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1565C0)
                )
            }
            1 -> {
                Text(
                    text = horaActual,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF37474F))
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                )
            }
            2 -> {
                Text(
                    text = horaActual,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF2E7D32),
                    modifier = Modifier
                        .border(3.dp, Color(0xFF2E7D32), RoundedCornerShape(12.dp))
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            estilo = (estilo + 1) % 3
        }) {
            Text("Cambiar diseño")
        }
    }
}

fun obtenerHoraActual(): String {
    val formato = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return formato.format(Date())
}