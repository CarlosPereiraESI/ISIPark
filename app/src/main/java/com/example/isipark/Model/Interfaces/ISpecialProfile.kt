package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.SpecialProfile

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