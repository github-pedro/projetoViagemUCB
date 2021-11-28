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
         val id = IntArray(200)
         val localDestino = Array<String>(200) { "it = $it" }
         val dataIda =  Array<String>(200) { "it = $it" }
         val tipoViagem =  Array<String>(200) { "it = $it" }
         val bagagem =  Array<String>(200) { "it = $it" }



        GlobalScope.launch(Dispatchers.IO) {
            var viagens:List<Viagem> = ViagemDatabase.getInstance(this@MinhasViagens).ViagemDAO().getAll()

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

//            for(viagem in viagens){
//                id[index] = viagem.uid!!
//                localDestino[index] = viagem.localDestino.toString()
//                dataIda[index] = viagem.dataIda.toString()
//                tipoViagem[index] = viagem.tipoViagem.toString()
//                bagagem[index] = viagem.bagagem.toString()
//                index = index+1
//            }

            //viagem?.forEach{

               // println(it)
//                Toast.makeText(applicationContext, viagem.localDestino.toString(), Toast.LENGTH_LONG).show()
//                id?.set(index, viagem.uid!!)
//                localDestino?.set(index, viagem.localDestino.toString())
//                dataIda?.set(index, viagem.dataIda.toString())
//                tipoViagem?.set(index, viagem.tipoViagem.toString())
//                bagagem?.set(index, viagem.bagagem.toString())
            //}


        }
//        val viagemAdapter = CustomAdapter(this,localDestino, dataIda, tipoViagem, bagagem)
//        val listViagem = findViewById<ListView>(R.id.idListView)
//        listViagem.adapter = viagemAdapter

//         viagem?.forEach{
//             id[index] = it.uid!!
//             localDestino[index] = it.localDestino.toString()
//             dataIda[index] = it.dataIda.toString()
//             tipoViagem[index] = it.tipoViagem.toString()
//             bagagem[index] = it.bagagem.toString()
//             println(it)
//                Toast.makeText(applicationContext, viagem.localDestino.toString(), Toast.LENGTH_LONG).show()
//                id?.set(index, viagem.uid!!)
//                localDestino?.set(index, viagem.localDestino.toString())
//                dataIda?.set(index, viagem.dataIda.toString())
//                tipoViagem?.set(index, viagem.tipoViagem.toString())
//                bagagem?.set(index, viagem.bagagem.toString())

         val viagemAdapter = CustomAdapter(this,localDestino, dataIda, tipoViagem, bagagem)
         val listViagem = findViewById<ListView>(R.id.idListView)
         listViagem.adapter = viagemAdapter

         }





    }

//    fun getViagem(){

//    }