import kotlin.random.Random

class JogoDaForca (private var palavra_da_forca: String, private var Dica: String) {

    private var TamanhoDaForca = palavra_da_forca.length
    private var palavras_encontradas = mutableListOf<Char>()
    private var acertos = 0
    private var tentativas = 6
    private var letras_usadas = ""

    fun start() {
        for (x in 0 until TamanhoDaForca) {
            palavras_encontradas.add('_')
        }
    }

    fun getTamanho():Int {
        return TamanhoDaForca
    }

    fun terminou(): Boolean {
        return this.acertos == this.TamanhoDaForca || this.tentativas == 0
    }

    fun getPalavra(): String {
        return this.palavras_encontradas.joinToString(" ")
    }

    fun getDica(): String {
        return this.Dica
    }

    fun getAcertos():Int {
        return this.acertos
    }

    fun getTentativas(): Int {
        return this.tentativas
    }

    fun LetrasUsadas(letra: String): String {
        if (letras_usadas.contains(letra[0])) {
            throw Throwable("Letra já usada")
        } else if (letra.length > 1) {
            throw Throwable("Digite uma única letra, apenas.")
        }
        else {
            letras_usadas += "${letra[0]} "
        }
        return letras_usadas
    }

    fun getLetrasUsadas (): String {
        return letras_usadas
    }


    fun LetrasDistintas():Int {
        var letrasDistintas = palavra_da_forca.uppercase().toList()
        return letrasDistintas.distinct().size
    }

    fun Adivinhar(letra: String) {
        try {
            LetrasUsadas(letra)
            var teste = 0

            for (c in 0 until TamanhoDaForca) {
                if (letra.uppercase() == palavra_da_forca[c].uppercase()) {
                    acertos ++
                    palavras_encontradas[c] = letra[0]
                    teste = 1
                }
            }
            if (teste == 0) {
                tentativas --
                println("Letra não existe na palavra. Tente novamente.")
            }
        }
        catch (e: Throwable) {
            println(e.message)
        }

    }
}