package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.VehicleType

@Dao
interface IVehicleType {
    @Query("SELECT * FROM vehicleType")
    fun getAll(): List<VehicleType>
    @Query("SELECT * FROM vehicleType WHERE IdVehicle = :id")
    fun findById(id: Int): VehicleType
    @Insert
    fun insertAll(vararg vecty: VehicleType)
    @Delete
    fun delete(vecty: VehicleType)
    @Update
    fun update(vararg vecty: VehicleType)
}