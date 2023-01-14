package com.example.isipark.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class VehicleType(val userID: Int, val vehicleTypeID: Int, val licensePlate: String) {
}*/

@Entity(tableName = "vehicleType")
data class VehicleType(@PrimaryKey(autoGenerate = true) val IdVehicle: Int=0,
                       val description: String?) {
}