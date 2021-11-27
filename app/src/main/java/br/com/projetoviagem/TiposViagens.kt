package br.com.projetoviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import br.com.projetoviagem.list.ListAmigos
import br.com.projetoviagem.list.ListFamilia
import br.com.projetoviagem.list.ListTrabalho

class TiposViagens : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipos_viagens)
        val imageButtonFamilia:ImageButton = findViewById(R.id.imageButtonFamilia)
        val imageButtonAmigos:ImageButton = findViewById(R.id.imageButtonAmigos)
        val imageButtonTrabalho:ImageButton = findViewById(R.id.imageButtonTrabalho)

        imageButtonFamilia.setOnClickListener{
            val intent = Intent(this, ListFamilia::class.java)
            startActivity(intent)
        }
        imageButtonAmigos.setOnClickListener{
            val intent = Intent(this, ListAmigos::class.java)
            startActivity(intent)
        }
        imageButtonTrabalho.setOnClickListener{
            val intent = Intent(this, ListTrabalho::class.java)
            startActivity(intent)
        }

    }
}