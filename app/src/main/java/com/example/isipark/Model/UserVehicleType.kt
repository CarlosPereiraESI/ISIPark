package com.example.isipark.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class UserVehicleType(val userID: Int, val vehicleTypeID: Int, val licensePlate: String) {
}*/

@Entity(tableName = "uservehicleType")
data class UserVehicleType(@PrimaryKey(autoGenerate = true) val userID: Int =0,
                           val vehicleTypeID: Int?,
                           val licensePlate: String?) {
}