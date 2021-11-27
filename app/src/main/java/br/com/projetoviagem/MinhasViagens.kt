package br.com.projetoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.projetocombancodados.roomdata.ViagemDatabase
import br.com.projetoviagem.roomdata.Viagem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MinhasViagens : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minhas_viagens)




        GlobalScope.launch(Dispatchers.IO) {
            var viagens:List<Viagem> = ViagemDatabase.getInstance(this@MinhasViagens).ViagemDAO().getAll()
            var id: Array<Int> = emptyArray()
            var localDestino: Array<String> = emptyArray()
            var dataIda: Array<String> = emptyArray()
            var tipoViagem: Array<String> = emptyArray()
            var bagagem: Array<String> = emptyArray()
            viagens?.forEachIndexed { index, viagem ->
                id[index] = viagem.uid!!
                localDestino[index] = viagem.localDestino.toString()
                dataIda[index] = viagem.dataIda.toString()
                tipoViagem[index] = viagem.tipoViagem.toString()
                bagagem[index] = viagem.bagagem.toString()
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
         }



//       val viagemAdapter = CustomAdapter(this,id, localDestino, dataIda, tipoViagem, bagagem)
//       val listViagem = findViewById<ListView>(R.id.idListView)
//        listViagem.adapter = viagemAdapter

    }

//    fun getViagem(){

//    }