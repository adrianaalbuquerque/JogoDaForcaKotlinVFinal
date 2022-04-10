package com.example.jogodaforcakotlin.repositorio

class BancoDePalavras {
    private var bancoPalavras = LinkedHashMap<String, String>()
    private var palavraSorteada = ""

    fun adiciona(palavra: String, dica: String) {
        this.bancoPalavras.put(palavra, dica) // daria pra fazer dessa forma também: this.bancoPalavras[key] = value onde a key é a palavra e o value a dica
    }
    fun sorteio() {
        this.palavraSorteada = this.bancoPalavras.keys.random()
    }

    fun palavrita(): String {
        return this.palavraSorteada
    }

    fun Dicaa(): String {
        return this.bancoPalavras.getValue(this.palavraSorteada)
    }
}