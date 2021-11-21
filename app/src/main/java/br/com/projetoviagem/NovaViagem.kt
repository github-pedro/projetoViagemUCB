package br.com.projetoviagem

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson

class NovaViagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_viagem)
        val dataIda:EditText = findViewById(R.id.editTextDate)
        val txtField:TextInputEditText = findViewById(R.id.txtField)
        val botaoCadastrar:Button = findViewById(R.id.botaoCadastrar)
        val spinnerDestinos:Spinner = findViewById(R.id.spinnerDestinos)
        val options = arrayOf("Brasilia", "Sao Paulo", "Rio de Janeiro")
        spinnerDestinos.adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, options)

        botaoCadastrar.setOnClickListener{
            //Toast.makeText(applicationContext,dataIda.text,Toast.LENGTH_LONG).show()
            //Toast.makeText(applicationContext,txtField.text,Toast.LENGTH_LONG).show()
            //Toast.makeText(applicationContext,spinnerDestinos.onItemSelectedListener.toString(),Toast.LENGTH_LONG).show()
            //Toast.makeText(applicationContext,dataIda.text,Toast.LENGTH_LONG).show()
        }
    }
}