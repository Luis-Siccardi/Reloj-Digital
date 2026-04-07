# Reloj Digital - Ejercicio de Android Studio

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