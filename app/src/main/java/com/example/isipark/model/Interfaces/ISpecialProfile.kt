package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.SpecialProfile

@Dao
interface ISpecialProfile {
    @Query("SELECT * FROM specialProfile")
    fun getAll(): List<SpecialProfile>
    @Query("SELECT * FROM specialProfile WHERE id = :id")
    fun findById(id: Int): SpecialProfile
    @Insert
    fun insertAll(vararg spcPro: SpecialProfile)
    @Delete
    fun delete(spcPro: SpecialProfile)
    @Update
    fun update(vararg spcPro: SpecialProfile)
}