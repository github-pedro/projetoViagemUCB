package br.com.projetoviagem

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
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

class NovaViagem : AppCompatActivity() {

    lateinit var spinnerResult:String

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var build: Notification.Builder
    private val ChannelId = "viagemNotificacao"
    private val desc = "Notifications"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_viagem)

        val dataIda:EditText = findViewById(R.id.editTextDate)
        var radioGroupResult:String = "null"
        val radioGroup:RadioGroup = findViewById(R.id.radioGroup)
        val radioTrabalho:RadioButton = findViewById(R.id.radioTrabalho)
        val radioLazer:RadioButton = findViewById(R.id.radioLazer)
        val txtField:TextInputEditText = findViewById(R.id.txtField)
        val botaoCadastrar:Button = findViewById(R.id.botaoCadastrar)
        val spinnerDestinos:Spinner = findViewById(R.id.spinnerDestinos)
        val estadosBr = Array<String>(27) { "Rondônia" }
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(this,MinhasViagens::class.java)

        val queue = Volley.newRequestQueue(this)
        val url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"

        // Metodo de requisição da url
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                var gson = Gson()
                // Armazena o response em um DataClass EstadosItem
                var estados = gson?.fromJson(response,Estados::class.java)
                estados?.forEachIndexed { index, estadosItem ->
                    estadosBr[index] = estadosItem.nome
                }
            },
            Response.ErrorListener {})

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

        // Armazena os dados obtidos na requisição em um spinner de opções
        spinnerDestinos.adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, estadosBr)

        // Metodo de click no botao Cadastrar
        botaoCadastrar.setOnClickListener{
            // Verifica se os campos não estao Vazios antes de Salvar
            if (!spinnerResult.isEmpty() && radioGroupResult != "nulll" && !dataIda.text.isEmpty() && !txtField.text?.isEmpty()!!){
                // coloca os valores digitados no objeto Viagem
                val objViagem = Viagem(null, spinnerResult , dataIda.text.toString(), radioGroupResult,txtField.text.toString() )
                GlobalScope.launch(Dispatchers.IO){
                    // Chama o metodo insert em ViagemDAO
                    ViagemDatabase.getInstance(this@NovaViagem).ViagemDAO().insert(objViagem)
                }
                Toast.makeText(applicationContext,"Sucesso",Toast.LENGTH_LONG).show()

                val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT)
                notificationChannel = NotificationChannel(ChannelId, desc,NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.lightColor = Color.GRAY
                notificationManager.createNotificationChannel(notificationChannel)
                build = Notification.Builder(this)
                    .setContentTitle("Cadastro Realizado!")
                    .setContentText("Agora você já pode visualizar suas viagens!")
                    .setSmallIcon(R.drawable.ic_aviao)
                    .setChannelId(ChannelId)
                    .setContentIntent(pendingIntent)

                notificationManager.notify(1, build.build())
            }else{
                Toast.makeText(applicationContext,"Aconteceu algo errado",Toast.LENGTH_LONG).show()
            }
        }

        // Acao de click nas opções do radioGroup
        radioGroup.setOnCheckedChangeListener { group , i ->
            // Verifica opção clicada
            if(i === R.id.radioTrabalho){
                // atribui o text do radioButton como resultado do click
                radioGroupResult = radioTrabalho.text.toString()
            } else if (i === R.id.radioLazer) {
                // atribui o text do radioButton como resultado do click
                radioGroupResult = radioLazer.text.toString()
            }
        }

        // Verifica opção clicada no Select
        spinnerDestinos.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            // Verifica o item clicado
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // Pega da lista de estadosBr, com base no index p2 do Item Selecionado
                spinnerResult = estadosBr[p2]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

    }
}