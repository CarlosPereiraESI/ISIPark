package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.PlaceType

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