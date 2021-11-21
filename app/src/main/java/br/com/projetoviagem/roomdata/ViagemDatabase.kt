package br.com.projetocombancodados.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.projetoviagem.roomdata.Viagem
import br.com.projetoviagem.roomdata.ViagemDAO

@Database(entities = [Viagem::class], version = 1)
abstract class ViagemDatabase:RoomDatabase() {
    abstract fun ViagemDAO(): ViagemDAO
    companion object{
        var INSTANCE:ViagemDatabase? = null
        fun getInstance(context: Context):ViagemDatabase{
            if (INSTANCE==null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,ViagemDatabase::class.java,"Viagem.db").build()
            }
            return INSTANCE!!
        }
    }
}