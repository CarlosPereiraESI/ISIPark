package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.UserMessage

@Dao
interface IUserMessage {
    @Query("SELECT * FROM usermessage")
    fun getAll(): List<UserMessage>
    @Query("SELECT * FROM usermessage WHERE userID = :iduser ")
    fun findById(iduser: Int): UserMessage
    @Insert
    fun insertAll(vararg usrmessage: UserMessage)
    @Delete
    fun delete(usrmessage: UserMessage)
    @Update
    fun update(vararg usrmessage: UserMessage)
}