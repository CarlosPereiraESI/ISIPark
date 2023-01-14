package com.example.isipark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class SpecialProfile(val id: Int, val name: String, val licensePlate: String,
                     val contact: String, val vehicleTypeID: Int) {
}*/

@Entity(tableName = "specialProfile")
data class SpecialProfile(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                          val name: String?, val licensePlate: String?,
                          val contact: String?, val vehicleTypeID: Int?) {
}
