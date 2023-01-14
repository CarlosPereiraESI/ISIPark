package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.Setor

@Dao
interface ISetor {
    @Query("SELECT * FROM setor")
    fun getAll(): List<Setor>
    @Query("SELECT * FROM setor WHERE id = :id")
    fun findById(id: Int): Setor
    @Insert
    fun insertAll(vararg set: Setor)
    @Delete
    fun delete(set: Setor)
    @Update
    fun update(vararg set: Setor)
}