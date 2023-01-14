package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.AdminMessage

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