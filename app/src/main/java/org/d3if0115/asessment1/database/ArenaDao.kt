package org.d3if0115.asessment1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0115.asessment1.model.Arena

@Dao
interface ArenaDao {
    @Insert
    suspend fun insert(arena: Arena)

    @Update
    suspend fun update(arena: Arena)

    @Query("SELECT * FROM arena ORDER BY lapangan, hargaBooking, tanggalBooking, namaCustomer ASC")
    fun getArena(): Flow<List<Arena>>

    @Query("SELECT * FROM arena WHERE id = :id")
    suspend fun getArenaById(id: Long): Arena?

    @Query("DELETE FROM arena WHERE id = :id")
    suspend fun deleteById(id: Long)
}