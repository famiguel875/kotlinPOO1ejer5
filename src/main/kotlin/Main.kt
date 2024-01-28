fun main() {
    val tiempoUsuario = obtenerDatosTiempo()

    println("Tiempo ingresado: $tiempoUsuario")

    val tiempoIncrementar = obtenerDatosTiempo()
    if (tiempoUsuario.incrementar(tiempoIncrementar)) {
        println("Tiempo después de incrementar: $tiempoUsuario")
    } else {
        println("Error al incrementar, el resultado supera las 23:59:59")
    }

    val tiempoDecrementar = obtenerDatosTiempo()
    if (tiempoUsuario.decrementar(tiempoDecrementar)) {
        println("Tiempo después de decrementar: $tiempoUsuario")
    } else {
        println("Error al decrementar, el resultado es menor que 00:00:00")
    }

    val tiempoComparar = obtenerDatosTiempo()
    when (tiempoUsuario.comparar(tiempoComparar)) {
        -1 -> println("El tiempo ingresado es menor que el tiempo actual.")
        0 -> println("El tiempo ingresado es igual al tiempo actual.")
        1 -> println("El tiempo ingresado es mayor que el tiempo actual.")
    }

    val tiempoCopiar = tiempoUsuario.copiar()
    println("Copia del tiempo actual: $tiempoCopiar")

    val tiempoSumar = obtenerDatosTiempo()
    val resultadoSumar = tiempoUsuario.sumar(tiempoSumar)
    if (resultadoSumar != null) {
        println("Resultado de sumar los tiempos: $resultadoSumar")
    } else {
        println("Error al sumar, el resultado supera las 23:59:59")
    }

    val tiempoRestar = obtenerDatosTiempo()
    val resultadoRestar = tiempoUsuario.restar(tiempoRestar)
    if (resultadoRestar != null) {
        println("Resultado de restar los tiempos: $resultadoRestar")
    } else {
        println("Error al restar, el resultado es menor que 00:00:00")
    }

    val tiempoCompararMayor = obtenerDatosTiempo()
    if (tiempoUsuario.esMayorQue(tiempoCompararMayor)) {
        println("El tiempo actual es mayor que el tiempo ingresado.")
    } else {
        println("El tiempo actual no es mayor que el tiempo ingresado.")
    }

    val tiempoCompararMenor = obtenerDatosTiempo()
    if (tiempoUsuario.esMenorQue(tiempoCompararMenor)) {
        println("El tiempo actual es menor que el tiempo ingresado.")
    } else {
        println("El tiempo actual no es menor que el tiempo ingresado.")
    }
}