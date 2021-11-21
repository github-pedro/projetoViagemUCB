package br.com.projetoviagem.roomdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Viagem")
data class Viagem (
    @PrimaryKey(autoGenerate = true)
    val uid:Int?,
    val localDestino:String?,
    val dataIda:String?,
    val tipoViagem:String?,
    val bagagem:String?
)