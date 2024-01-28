class Tiempo(private var hora: Int, private var minuto: Int, private var segundo: Int) {
    init {
        require(hora in 0..23) { "La hora debe estar entre 0 y 23" }
        ajustarTiempo()
    }

    private fun ajustarTiempo() {
        if (segundo >= 60) {
            minuto += segundo / 60
            segundo %= 60
        }

        if (minuto >= 60) {
            hora += minuto / 60
            minuto %= 60
        }

        hora %= 24
    }

    override fun toString(): String {
        return "$hora h $minuto m $segundo s"
    }

    fun incrementar(t: Tiempo): Boolean {
        hora += t.hora
        minuto += t.minuto
        segundo += t.segundo
        ajustarTiempo()

        return !(hora > 23 || minuto > 59 || segundo > 59)
    }

    fun decrementar(t: Tiempo): Boolean {
        hora -= t.hora
        minuto -= t.minuto
        segundo -= t.segundo
        ajustarTiempo()

        return !(hora < 0 || minuto < 0 || segundo < 0)
    }

    fun comparar(t: Tiempo): Int {
        return when {
            hora < t.hora || (hora == t.hora && (minuto < t.minuto || (minuto == t.minuto && segundo < t.segundo))) -> -1
            hora == t.hora && minuto == t.minuto && segundo == t.segundo -> 0
            else -> 1
        }
    }

    fun copiar(): Tiempo {
        return Tiempo(hora, minuto, segundo)
    }

    fun copiar(t: Tiempo) {
        hora = t.hora
        minuto = t.minuto
        segundo = t.segundo
    }

    fun sumar(t: Tiempo): Tiempo? {
        val resultado = Tiempo(hora, minuto, segundo)
        resultado.hora += t.hora
        resultado.minuto += t.minuto
        resultado.segundo += t.segundo
        resultado.ajustarTiempo()

        return if (resultado.hora > 23 || resultado.minuto > 59 || resultado.segundo > 59) {
            null
        } else {
            resultado
        }
    }

    fun restar(t: Tiempo): Tiempo? {
        val resultado = Tiempo(hora, minuto, segundo)
        resultado.hora -= t.hora
        resultado.minuto -= t.minuto
        resultado.segundo -= t.segundo
        resultado.ajustarTiempo()

        return if (resultado.hora < 0 || resultado.minuto < 0 || resultado.segundo < 0) {
            null
        } else {
            resultado
        }
    }

    fun esMayorQue(t: Tiempo): Boolean {
        return comparar(t) == 1
    }

    fun esMenorQue(t: Tiempo): Boolean {
        return comparar(t) == -1
    }
}

fun obtenerDatosTiempo(): Tiempo {
    print("Introduce la hora: ")
    val hora = readLine()?.toIntOrNull() ?: 0

    print("Introduce el minuto: ")
    val minuto = readLine()?.toIntOrNull() ?: 0

    print("Introduce el segundo: ")
    val segundo = readLine()?.toIntOrNull() ?: 0

    return Tiempo(hora, minuto, segundo)
}


