package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.AdminMessage

@Dao
interface IAdminMessage {
    @Query("SELECT * FROM adminMessage")
    fun getAll(): List<AdminMessage>
    @Query("SELECT * FROM adminMessage WHERE id = :id")
    fun findById(id: Int): AdminMessage
    @Insert
    fun insertAll(vararg amessage: AdminMessage)
    @Delete
    fun delete(amessage: AdminMessage)
    @Update
    fun update(vararg amessage: AdminMessage)
}