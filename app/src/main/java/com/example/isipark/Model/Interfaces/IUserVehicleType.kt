package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.UserVehicleType

@Dao
interface IUserVehicleType {
    @Query("SELECT * FROM uservehicleType")
    fun getAll(): List<UserVehicleType>
    @Query("SELECT * FROM uservehicleType WHERE userID = :idus AND vehicleTypeID = :idvt ")
    fun findById(idus: Int, idvt: Int): UserVehicleType
    @Insert
    fun insertAll(vararg usvt: UserVehicleType)
    @Delete
    fun delete(usvt: UserVehicleType)
    @Update
    fun update(vararg usvt: UserVehicleType)
}