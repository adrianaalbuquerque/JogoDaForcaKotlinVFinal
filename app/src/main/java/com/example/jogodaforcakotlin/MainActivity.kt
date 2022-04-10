package com.example.jogodaforcakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.jogodaforcakotlin.facade.Fachada

class MainActivity : AppCompatActivity() {
    private lateinit var fachada: Fachada
    private lateinit var tvdica: TextView
    private lateinit var tvpalavra: TextView
    private lateinit var tvinfos: TextView
    private lateinit var botaozinho: Button
    private lateinit var entrada: EditText
    private lateinit var imagem: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //implementação on create da sua super classe
        setContentView(R.layout.activity_main) // activity da pasta layout do res, o xml

        this.fachada = Fachada()
        fachada.Padrao()
        fachada.start()

        this.tvdica = findViewById(R.id.TextViewDica)
        this.tvdica.text = fachada.diquinha()

        tvpalavra = findViewById(R.id.textViewPalavra)
        this.tvpalavra.text = fachada.palavrota()

        tvinfos = findViewById(R.id.textViewinfos)
        tvinfos.text = fachada.infos()

        botaozinho = findViewById(R.id.clicador)

        entrada = findViewById(R.id.TextEntrada)

        botaozinho.setOnClickListener {
            this.fachada.jogar(this.entrada.text.toString())
            this.tvpalavra.text = this.fachada.palavrota()
            this.tvinfos.text = this.fachada.infos()
            var imagemm = "cave${6-this.fachada.tentativas()}"
            this.imagem.setImageResource(resources.getIdentifier(imagemm, "drawable", packageName))

            if (this.fachada.terminou()) {
                this.botaozinho.isEnabled = false
                if (this.fachada.ganhou()) {
                    val intent = Intent(this, Resultado::class.java).apply {
                        putExtra("Resultado", "Ganhou!!!")
                    }
                    if (intent.resolveActivity(packageManager)!= null) {
                        startActivity(intent)
                    }
                } else {
                    val intent = Intent(this, Resultado::class.java).apply {
                        putExtra("Resultado", "Perdeu!!!")
                    }
                    if (intent.resolveActivity(packageManager)!= null) {
                        startActivity(intent)
                    }
                }
            }
        }

        this.imagem = findViewById(R.id.imageView)

    }
}

// esse layout mostra como será a aplicação
//É possível alterar o layout de 3 formas: Code, Split e Design
//E nesse layout só vai ter uma tela em branco com "hello world"

