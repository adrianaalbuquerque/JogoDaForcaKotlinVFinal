package com.example.jogodaforcakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Resultado : AppCompatActivity() {

    private lateinit var resultadoText: TextView
    private lateinit var resultadinhoImage: ImageView
    private lateinit var botaoResultado: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        this.resultadoText = findViewById(R.id.resultadinhoo)
        this.resultadinhoImage = findViewById(R.id.resultadopcr)
        this.botaoResultado = findViewById(R.id.boton)

        if (intent.hasExtra("Resultado")) {
            this.resultadoText.text = intent.getStringExtra("Resultado")
            if (intent.getStringExtra("Resultado") == "Ganhou!!!") {
                this.resultadinhoImage.setImageResource(resources.getIdentifier("youwin", "drawable", packageName))
            } else {
                this.resultadinhoImage.setImageResource(resources.getIdentifier("lose", "drawable", packageName))
            }
        }
        this.botaoResultado.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            if (intent.resolveActivity(packageManager)!= null) {
                startActivity(intent)
            }
        }
    }
}