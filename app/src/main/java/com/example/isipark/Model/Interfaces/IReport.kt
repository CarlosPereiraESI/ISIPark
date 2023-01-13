package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.Report

@Dao
interface IReport {
    @Query("SELECT * FROM report")
    fun getAll(): List<Report>
    @Query("SELECT * FROM report WHERE id = :id")
    fun findById(id: Int): Report
    @Insert
    fun insertAll(vararg rep: Report)
    @Delete
    fun delete(rep: Report)
    @Update
    fun updateComment(vararg rep: Report)
}