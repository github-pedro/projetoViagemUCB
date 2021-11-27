package br.com.projetoviagem.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.projetoviagem.R

class CustomAdapterDestinos(val context:Activity, private val imgIdDestino:Array<Int>, private val destino:Array<String>, private val descricao:Array<String>) : ArrayAdapter<String>(context,
    R.layout.custom_listview,destino) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflate = context.layoutInflater
        val view = inflate.inflate(R.layout.custom_listview_destino,null, true)
        val imgDestino = view.findViewById<ImageView>(R.id.imgDestino)
        val txtDestino = view.findViewById<TextView>(R.id.txtDestino)
        val txtDescricao = view.findViewById<TextView>(R.id.txtDescricao)

        txtDestino.text = destino[position]
        txtDescricao.text = descricao[position]
        imgDestino.setImageResource(imgIdDestino[position])

        return view
    }


}