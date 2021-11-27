package br.com.projetoviagem.roomdata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ViagemDAO {
    @Insert
    suspend fun insert(viagem:Viagem)

    @Query("delete from Viagem where uid=:uid")
    suspend fun delete(uid: Int)

    @Update
    suspend fun update(viagem: Viagem)

    @Query("select * from Viagem")
    fun getAll(): List<Viagem>
}