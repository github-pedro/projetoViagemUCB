package br.com.projetoviagem.Adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.com.projetoviagem.R

class CustomAdapter(val context:Activity, private val localDestino:Array<String>, private val dataIda:Array<String>, private val tipoViagem:Array<String>, private val bagagem:Array<String>) : ArrayAdapter<String>(context,
    R.layout.custom_listview,bagagem) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflate = context.layoutInflater
        val view = inflate.inflate(R.layout.custom_listview,null, true)
        val localDestinoView = view.findViewById<TextView>(R.id.txtLocal)
        val dataIdaView = view.findViewById<TextView>(R.id.txtData)
        val tipoViagemView = view.findViewById<TextView>(R.id.txtTipo)
        val bagagemView = view.findViewById<TextView>(R.id.txtBagagem)

        localDestinoView.text = localDestino[position]
        dataIdaView.text = dataIda[position]
        tipoViagemView.text = tipoViagem[position]
        bagagemView.text = bagagem[position]

        return view
    }


}