package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.History

@Dao
interface IHistory {
    @Query("SELECT * FROM history")
    fun getAll(): List<History>
    @Query("SELECT * FROM history WHERE id = :id")
    fun findById(id: Int): History
    @Insert
    fun insertAll(vararg hist: History)
    @Delete
    fun delete(hist: History)
    @Update
    fun update(vararg hist: History)
}