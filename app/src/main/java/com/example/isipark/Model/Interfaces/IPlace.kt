package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.Place

@Dao
interface IPlace {
    @Query("SELECT * FROM place")
    fun getAll(): List<Place>
    @Query("SELECT * FROM place WHERE id = :id")
    fun findById(id: Int): Place
    @Insert
    fun insertAll(vararg pla: Place)
    @Delete
    fun delete(pla: Place)
    @Update
    fun update(vararg pla: Place)
}