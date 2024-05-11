package org.d3if0115.asessment1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Arena")
data class Arena(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val namaCustomer: String,
    val tanggalBooking: String,
    val hargaBooking: String,
    val lapangan: String
)
