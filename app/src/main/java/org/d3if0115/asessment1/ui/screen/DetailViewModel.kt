package org.d3if0115.asessment1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0115.asessment1.database.ArenaDao
import org.d3if0115.asessment1.model.Arena

class DetailViewModel (private val dao: ArenaDao) : ViewModel() {

    fun insert(namaCostumer: String, tanggalBooking: String, hargaBooking: String, lapangan: String) {
        val arena = Arena(
            namaCustomer = namaCostumer,
            tanggalBooking = tanggalBooking,
            hargaBooking = hargaBooking,
            lapangan = lapangan
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(arena)
        }
    }

    suspend fun getArena(id: Long): Arena? {
        return dao.getArenaById(id)
    }

    fun update(id: Long, namaCostumer: String, tanggalBooking: String, hargaBooking: String, lapangan: String) {
        val arena = Arena(
            id = id,
            namaCustomer = namaCostumer,
            tanggalBooking = tanggalBooking,
            hargaBooking = hargaBooking,
            lapangan = lapangan
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(arena)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}