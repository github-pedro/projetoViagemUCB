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

        // Metodo de click no botão Nova Viagem
        buttonNovaViagem.setOnClickListener {
            val intent = Intent(this, NovaViagem::class.java)
            startActivity(intent)
        }
        // Metodo de click no botão Minhas Viagens
        buttonMinhasViagens.setOnClickListener {
            val intent = Intent(this, MinhasViagens::class.java)
            startActivity(intent)
        }
        // Metodo de click no botão Opções de Viagens
        buttonOpcaoViagem.setOnClickListener {
            val intent = Intent(this, TiposViagens::class.java)
            startActivity(intent)
        }
    }

}