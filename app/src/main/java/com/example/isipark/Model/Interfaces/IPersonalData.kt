package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.History
import com.example.isipark.Model.PersonalData

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