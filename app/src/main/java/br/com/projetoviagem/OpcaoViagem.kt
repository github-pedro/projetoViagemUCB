package br.com.projetoviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OpcaoViagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcao_viagem)
        val txtViewNome:TextView = findViewById(R.id.txtViewNome)
        val buttonNovaViagem:Button = findViewById(R.id.botaoNovaViagem)
        val buttonMinhasViagens:Button = findViewById(R.id.botaoMinhasViagens)
        val buttonOpcaoViagem:Button = findViewById(R.id.botaoOpcoesViagens)
        var nome = intent.getStringExtra("nome")
        txtViewNome.text = nome

        buttonNovaViagem.setOnClickListener {
            val intent = Intent(this, NovaViagem::class.java)
            startActivity(intent)
        }
        buttonMinhasViagens.setOnClickListener {
            val intent = Intent(this, MinhasViagens::class.java)
            startActivity(intent)
        }
        buttonOpcaoViagem.setOnClickListener {
            val intent = Intent(this, TiposViagens::class.java)
            startActivity(intent)
        }
    }

}