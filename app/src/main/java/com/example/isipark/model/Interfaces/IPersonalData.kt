package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.PersonalData

@Dao
interface IPersonalData {
    @Query("SELECT * FROM personalData")
    fun getAll(): List<PersonalData>
    @Query("SELECT * FROM personalData WHERE number = :id")
    fun findById(id: Int): PersonalData
    @Insert
    fun insertAll(vararg persD: PersonalData)
    @Delete
    fun delete(persD: PersonalData)
    @Update
    fun update(vararg persD: PersonalData)
}