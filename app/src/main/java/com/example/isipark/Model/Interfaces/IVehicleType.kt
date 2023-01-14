package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.VehicleType

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