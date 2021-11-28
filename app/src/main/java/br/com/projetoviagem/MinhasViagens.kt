package br.com.projetoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import br.com.projetocombancodados.roomdata.ViagemDatabase
import br.com.projetoviagem.Adapter.CustomAdapter
import br.com.projetoviagem.roomdata.Viagem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MinhasViagens : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_viagens)
         val id = IntArray(40)
         val localDestino = Array<String>(40) { "Vazio" }
         val dataIda =  Array<String>(40) { "Vazio" }
         val tipoViagem =  Array<String>(40) { "Vazio" }
         val bagagem =  Array<String>(40) { "Vazio" }

        GlobalScope.launch(Dispatchers.IO) {
            // Pega o List do Objeto Viagem pelo getAll
            var viagens:List<Viagem> = ViagemDatabase.getInstance(this@MinhasViagens).ViagemDAO().getAll()

            // Percorre a Lista e atribui os valores para os Arrays
            viagens?.forEachIndexed { index, viagem ->
                id[index] = viagem.uid!!
                localDestino[index] = viagem.localDestino.toString()
                println(localDestino[index])
                dataIda[index] = viagem.dataIda.toString()
                println(dataIda[index])
                tipoViagem[index] = viagem.tipoViagem.toString()
                println(tipoViagem[index])
                bagagem[index] = viagem.bagagem.toString()
                println(bagagem[index])
            }

        }

         // Manda os Arrays atribuidos de Viagem para a CustomAdapter
         val viagemAdapter = CustomAdapter(this,localDestino, dataIda, tipoViagem, bagagem)
         val listViagem = findViewById<ListView>(R.id.idListView)
         listViagem.adapter = viagemAdapter

         }
    }
