package br.com.projetoviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var getNome:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference = SharedPreference(this)
        val nome: EditText = findViewById(R.id.editTextNome)
        val button: Button = findViewById(R.id.buttonEntrar)
        getNome = sharedPreference.getValue("NOME").toString()
        nome.setText(getNome)

        // Aciona o botão de entrar no menu de opções
        button.setOnClickListener {

            // Verifica se o nome é diferente de vazio para prosseguir
            if(!nome.text.isEmpty()) {

                // Salva e Retorna o nome digitado no SharedPreferences
                sharedPreference.save("NOME", nome.text.toString())
                getNome = sharedPreference.getValue("NOME").toString()
                val intent = Intent(this, OpcaoViagem::class.java)
                intent.putExtra("nome", getNome)

                //Chama a activity OpcaoViagem
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext,"Preencha o campo com seu nome!",Toast.LENGTH_LONG).show()
            }
        }
    }

}