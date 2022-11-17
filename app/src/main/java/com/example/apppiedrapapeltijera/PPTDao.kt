package com.example.apppiedrapapeltijera

import androidx.room.*

@Dao
interface PPTDao {
    @Query("SELECT * FROM ppt_table")
    fun obtenerTodo(): List<PPT>

    @Query("SELECT * FROM ppt_table WHERE nick LIKE :nombreUsuario")
    suspend fun obtenerDatosJugador(nombreUsuario: String): PPT

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(datosJugador: PPT)

    @Query("UPDATE ppt_table SET partidas_jugadas=(partidas_jugadas+1) WHERE nick=:nombreUsuario")
    suspend fun aumentarPartidasJugadas(nombreUsuario: String)
}