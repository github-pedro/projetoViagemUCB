package br.com.projetoviagem

import android.content.Context
import android.content.SharedPreferences

class SharedPreference (context: Context) {

    private val PREFERENCE_NOME = "NOME"
    val sharedPreference: SharedPreferences = context.getSharedPreferences(PREFERENCE_NOME, Context.MODE_PRIVATE)

    // Metodo de save do SharedPreferences
    fun save(key_nome:String,valor:String){
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString(key_nome,valor)
        editor.commit()
    }
    // Metodo de get do SharedPreferences
    fun getValue(key_cep: String):String?{
        return sharedPreference.getString(key_cep,null)
    }
}