## Práctico 1: Reloj Digital - Ejercicio de Android Studio

Este repositorio contiene el material para trabajar en un ejercicio introductorio de desarrollo Android con **Jetpack Compose**. La propuesta consiste en transformar la actividad vacía que crea Android Studio en una aplicación que muestre un reloj digital que se actualiza automáticamente y permite alternar entre distintos estilos visuales.

## Objetivos de aprendizaje

- Reconocer la estructura básica de un proyecto nuevo en Android Studio.
- Identificar dónde se modifica la interfaz en un proyecto con Compose.
- Mostrar información en pantalla usando `Text`.
- Utilizar variables de estado (`remember` y `mutableStateOf`) para controlar la interfaz.
- Actualizar la interfaz automáticamente con `LaunchedEffect`.
- Añadir un botón que modifique una variable de estado y cambie la apariencia del reloj.
- Diseñar tres estilos diferentes para la misma información.

## Archivos incluidos

- `app/src/main/java/com/example/relojsimple/MainActivity_base.kt`: código base que deben completar los estudiantes.
- `app/src/main/java/com/example/relojsimple/MainActivity_solucion.kt`: solución completa como referencia para el docente.
- `EVALUACION.md`: criterios de evaluación propuestos.
- `README.md`: descripción general y guía paso a paso.

## Pasos para comenzar

1. Crear un proyecto nuevo en **Android Studio** eligiendo *Empty Activity*. Puede llamarse `RelojSimple`.
2. Copiar el contenido de `MainActivity_base.kt` en el archivo `MainActivity.kt` de su proyecto, sustituyendo el código original generado por Android Studio.
3. Seguir las consignas y completar el código donde se indica con comentarios `// TODO`.
4. Para comprobar la solución, puede comparar con el contenido de `MainActivity_solucion.kt`.

## Guía paso a paso para el ejercicio

1. **Mostrar un texto**: cambia el texto inicial "Hello Android!" por un texto fijo, por ejemplo `"Mi primer reloj"`, y ejecútalo en el emulador o dispositivo.
2. **Mostrar una hora fija**: reemplaza el texto por una hora, como `"10:30:00"`, y ajusta el tamaño del texto usando `fontSize = 40.sp`.
3. **Agregar un botón**: crea una variable de estado llamada `estilo` e inicialízala en `0` con `remember`. Añade un botón debajo del reloj que al pulsarse cambie el valor de `estilo` y, en función de ese valor, modifique la apariencia del texto (por ejemplo, el tamaño o color).
4. **Mostrar la hora actual**: implementa una función `obtenerHoraActual()` que devuelva un `String` con la hora del sistema en formato `"HH:mm:ss"`. Crea una variable de estado `horaActual` y actualízala cada segundo dentro de un `LaunchedEffect` con `delay(1000)`.
5. **Diseñar tres estilos diferentes**: utiliza una sentencia `when` sobre la variable `estilo` para mostrar el reloj con tres apariencias distintas (tamaños, colores, bordes, fondos, etc.). Al pulsar el botón, incrementa `estilo` de forma cíclica: `(estilo + 1) % 3`.

## Actividades opcionales

- Mostrar también la fecha actual.
- Agregar un título encima del reloj que diga `Mi reloj digital`.
- Añadir un cuarto diseño creado por cada estudiante.
- Cambiar el color de fondo de la aplicación según el estilo seleccionado.

Para más información sobre Compose y desarrollo Android consulta la documentación oficial de [Jetpack Compose](https://developer.android.com/jetpack/compose).

---

## Práctico 2: Agregar un medidor de decibeles con el micrófono del celular

### Descripción general
En este práctico vamos a ampliar la aplicación del reloj digital realizada en Android Studio con Jetpack Compose.
La nueva función será un medidor de sonido que utilice el micrófono del celular para mostrar un valor aproximado en decibeles.

La aplicación deberá mostrar:
- La hora actual.
- Un medidor de sonido.
- El nivel aproximado de ruido en dB.
- Un mensaje según el nivel detectado.
- Un cambio visual según el nivel de sonido.

Este práctico permite integrar conceptos de programación, sensores del celular, permisos de Android, variables de estado y actualización automática de la interfaz.

## Objetivos
- Reconocer cómo se agregan permisos en un proyecto Android.
- Comprender por qué Android solicita permisos para acceder al micrófono.
- Utilizar el micrófono del celular como sensor de entrada.
- Mostrar información en pantalla usando Jetpack Compose.
- Utilizar variables de estado con `remember` y `mutableStateOf`.
- Actualizar datos automáticamente usando `LaunchedEffect`.
- Clasificar un valor numérico según diferentes condiciones.
- Cambiar colores o mensajes según el nivel detectado.
- Diferenciar entre una medición aproximada y una medición profesional.

## Importante
El valor de decibeles mostrado por la aplicación será aproximado.
Un celular no reemplaza a un sonómetro profesional, ya que cada dispositivo tiene micrófonos diferentes y no siempre están calibrados.

## Resultado esperado
Al finalizar el práctico, la aplicación deberá mostrar una pantalla similar a esta:
***
Mi reloj digital
14:35:21
Medidor de sonido
Nivel actual: 58 dB
Ruido moderado
Gráfico
██████░░░░
***

## Parte 1: Agregar el permiso del micrófono
Para que la aplicación pueda usar el micrófono del celular, primero hay que declarar el permiso correspondiente.
Abrir el archivo: app/src/main/AndroidManifest.xml

Agregar la siguiente línea antes de la etiqueta `<application>`:

```xml
<uses-permission android:name="android.permission.RECORD_AUDIO" />
```

El archivo debería quedar parecido a este ejemplo:
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
    <application
        android:allowBackup="true"
        android:label="RelojSimple"
        android:theme="@style/Theme.RelojSimple">
        <!-- Actividades de la aplicación -->
    </application>
</manifest>
```

## Parte 2: Pedir permiso desde la aplicación
Android no permite usar el micrófono directamente sin autorización del usuario.
Por eso, la aplicación deberá tener un botón que diga: Activar medidor de sonido

Cuando el usuario toque ese botón:
- La aplicación debe pedir permiso para usar el micrófono.
- Si el permiso fue aceptado, se activa el medidor.
- Si el permiso fue rechazado, se muestra un mensaje aclaratorio.

Mensaje sugerido:
```text
No se puede medir el sonido sin permiso de micrófono.
```

## Parte 3: Agregar la sección visual del medidor

Debajo del reloj digital, agregar una nueva sección con el título:

```text
Medidor de sonido
```

La pantalla deberá mostrar:

- Un título.
- El valor actual aproximado en decibeles.
- Un mensaje según el nivel de ruido.
- Algún cambio visual, como color, tamaño o barra indicadora.

Ejemplo de pantalla:

```text
Mi reloj digital
14:35:21

Medidor de sonido
Nivel actual: 58 dB
Ruido moderado
```

## Parte 4: Crear variables de estado

Para guardar el valor de los decibeles y actualizar la pantalla, se deben usar variables de estado.
Ejemplo orientativo:

```kotlin
var decibeles by remember { mutableStateOf(0.0) }
var medidorActivo by remember { mutableStateOf(false) }
var permisoConcedido by remember { mutableStateOf(false) }
```

Estas variables permiten que la interfaz cambie automáticamente cuando cambia su valor.

## Parte 5: Clasificar el nivel de ruido

La aplicación deberá mostrar un mensaje distinto según el valor detectado.

| Nivel aproximado | Mensaje |
|---|---|
| Menos de 45 dB | Ambiente tranquilo |
| Entre 45 y 70 dB | Ruido moderado |
| Más de 70 dB | Ruido alto |

Ejemplo de código orientativo:

```kotlin
val mensaje = when {
    decibeles < 45 -> "Ambiente tranquilo"
    decibeles < 70 -> "Ruido moderado"
    else -> "Ruido alto"
}
```

## Parte 6: Cambiar el color según el nivel de sonido

Además del mensaje, la aplicación deberá cambiar algún elemento visual según el nivel de ruido.
Por ejemplo:

| Nivel | Color sugerido |
|---|---|
| Ambiente tranquilo | Verde |
| Ruido moderado | Amarillo o naranja |
| Ruido alto | Rojo |

Ejemplo orientativo:

```kotlin
val colorNivel = when {
    decibeles < 45 -> Color.Green
    decibeles < 70 -> Color.Yellow
    else -> Color.Red
}
```

Ese color puede aplicarse al texto, al fondo de una tarjeta, a una barra visual o a algún indicador.

## Parte 7: Calcular los decibeles aproximados

Para calcular un valor aproximado de sonido, se puede usar una función como la siguiente:

```kotlin
fun calcularDecibeles(buffer: ShortArray, cantidadLeida: Int): Double {
    var suma = 0.0
    for (i in 0 until cantidadLeida) {
        suma += buffer[i] * buffer[i]
    }
    val promedio = suma / cantidadLeida
    val rms = kotlin.math.sqrt(promedio)
    return if (rms > 0) {
        20 * kotlin.math.log10(rms)
    } else {
        0.0
    }
}
```

### Explicación simple

El micrófono captura pequeñas variaciones de sonido como números.

Luego:

1. Se leen los datos del micrófono.
2. Se calcula una intensidad promedio.
3. Esa intensidad se transforma en un valor aproximado de decibeles.
4. Ese valor se guarda en una variable.
5. La interfaz muestra el valor actualizado.

## Parte 8: Actualizar el valor automáticamente

Al igual que el reloj actualiza la hora cada segundo, el medidor de sonido debe actualizar el valor de decibeles de forma automática.
Se puede usar `LaunchedEffect` para ejecutar una tarea mientras el medidor está activo.

Ejemplo orientativo:

```kotlin
LaunchedEffect(medidorActivo) {
    if (medidorActivo) {
        while (true) {
            // Leer sonido del micrófono
            // Calcular decibeles
            // Actualizar la variable decibeles
            delay(500)
        }
    }
}
```

La idea es que el valor no quede fijo, sino que cambie según el sonido del ambiente.

## Parte 9: Crear una barra visual de sonido

Como mejora visual, se puede representar el nivel de sonido con una barra.

Ejemplo:

```text
Nivel bajo:  ███░░░░░░░
Nivel medio: ██████░░░░
Nivel alto:  ██████████
```

También puede usarse una barra con `Box`, `LinearProgressIndicator` o cualquier recurso visual de Compose.

Ejemplo conceptual:

```kotlin
val progreso = (decibeles / 100).coerceIn(0.0, 1.0).toFloat()
```

Ese valor puede usarse para representar gráficamente el nivel de sonido.

## Requisitos mínimos del práctico

La aplicación debe cumplir con los siguientes puntos:
- Mostrar el reloj digital funcionando.
- Agregar una sección llamada `Medidor de sonido`.
- Declarar el permiso del micrófono en `AndroidManifest.xml`.
- Pedir permiso para usar el micrófono.
- Mostrar un valor aproximado en decibeles.
- Actualizar el valor automáticamente.
- Mostrar un mensaje según el nivel de ruido.
- Cambiar algún color o elemento visual según el nivel detectado.

## Actividades opcionales

Pueden agregar:
- Fecha actual debajo del reloj.
- Valor máximo de ruido detectado.
- Promedio de sonido de los últimos segundos.
- Botón para iniciar y detener el medidor.
- Cuarto estilo visual para el reloj.
- Modo aula: mostrar una advertencia cuando el ruido supere cierto nivel.
- Un mensaje personalizado cuando el aula esté demasiado ruidosa.
- Un diseño tipo panel de control.

## Preguntas para responder en la carpeta

Responder con palabras propias:

1. ¿Por qué una aplicación necesita permiso para usar el micrófono?
2. ¿Por qué el valor de decibeles obtenido con el celular es aproximado?
3. ¿Qué variable de estado guarda el valor de los decibeles?
4. ¿Qué parte del código permite actualizar el valor automáticamente?
5. ¿Qué diferencia hay entre mostrar un valor fijo y medir el sonido real?
6. ¿Qué sucede si el usuario no acepta el permiso del micrófono?
7. ¿Cómo podría usarse esta app dentro del aula?
8. ¿Qué mejora le agregarías a esta aplicación?


## Condiciones de aprobación

Para aprobar el práctico, la aplicación debe:

- Ejecutarse sin errores.
- Mostrar correctamente el reloj digital.
- Incluir la sección del medidor de sonido.
- Mostrar un valor de sonido, aunque sea aproximado.
- Clasificar el nivel de ruido.
- Tener una interfaz clara y ordenada.
- Poder ser explicada por el estudiante.

## Recomendaciones para probar la aplicación

Para probar el medidor, se pueden realizar las siguientes pruebas:
1. Ejecutar la aplicación en un ambiente silencioso.
2. Hablar cerca del micrófono.
3. Aplaudir suavemente.
4. Poner música a bajo volumen.
5. Comparar cómo cambia el valor mostrado.

No se debe gritar cerca del celular ni exponerlo a sonidos extremadamente fuertes.

## Cierre del práctico

Este práctico permite transformar una aplicación simple de reloj digital en una aplicación que también utiliza un sensor del celular.
A partir de este ejercicio, se puede pensar en nuevas aplicaciones:

- Medidor de ruido para el aula.
- Detector de ambientes silenciosos.
- Registro de niveles de sonido.
- App de convivencia escolar.
- Panel de control ambiental.
- Proyecto combinado con sensores externos o placas como Arduino o ESP32.
