package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.PlaceType

@Dao
interface IPlaceType {
    @Query("SELECT * FROM placeType")
    fun getAll(): List<PlaceType>
    @Query("SELECT * FROM placeType WHERE id = :id")
    fun findById(id: Int) : PlaceType
    @Insert
    fun insertAll(vararg platy: PlaceType)
    @Delete
    fun delete(platy: PlaceType)
    @Update
    fun update(vararg platy: PlaceType)

}