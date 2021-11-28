package br.com.projetoviagem

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.projetocombancodados.roomdata.ViagemDatabase
import br.com.projetoviagem.dataClass.Estados
import br.com.projetoviagem.roomdata.Viagem
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

class NovaViagem : AppCompatActivity() {
    lateinit var spinnerResult:String
    lateinit var radioGroupResult:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_viagem)
        val dataIda:EditText = findViewById(R.id.editTextDate)
        val radioGroup:RadioGroup = findViewById(R.id.radioGroup)
        val radioTrabalho:RadioButton = findViewById(R.id.radioTrabalho)
        val radioLazer:RadioButton = findViewById(R.id.radioLazer)
        val txtField:TextInputEditText = findViewById(R.id.txtField)
        val botaoCadastrar:Button = findViewById(R.id.botaoCadastrar)
        val spinnerDestinos:Spinner = findViewById(R.id.spinnerDestinos)
        //val options = arrayOf("Brasilia", "Sao Paulo", "Rio de Janeiro")
        val estadosBr = Array<String>(27) { "it = $it" }


        val queue = Volley.newRequestQueue(this)
        val url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"


        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                var gson = Gson()
                var estados = gson?.fromJson(response,Estados::class.java)
                var index = 0
                estados?.forEachIndexed { index, estadosItem ->
                    estadosBr[index] = estadosItem.nome
                }
            },
            Response.ErrorListener {})

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

        spinnerDestinos.adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, estadosBr)

        botaoCadastrar.setOnClickListener{
            if (!spinnerResult.isEmpty() && !radioGroupResult.isEmpty() && !dataIda.text.isEmpty() && !txtField.text?.isEmpty()!!){
                val objViagem = Viagem(null, spinnerResult , dataIda.text.toString(), radioGroupResult,txtField.text.toString() )
                GlobalScope.launch(Dispatchers.IO){
                    ViagemDatabase.getInstance(this@NovaViagem).ViagemDAO().insert(objViagem)
                }
                Toast.makeText(applicationContext,"Sucesso",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext,"Aconteceu algo errado",Toast.LENGTH_LONG).show()
            }
        }

        radioGroup.setOnCheckedChangeListener { group , i ->
            if(i === R.id.radioTrabalho){
                radioGroupResult = radioTrabalho.text.toString()
            } else if (i === R.id.radioLazer) {
                radioGroupResult = radioLazer.text.toString()
            }
        }

        spinnerDestinos.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerResult = estadosBr[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }


    }
}