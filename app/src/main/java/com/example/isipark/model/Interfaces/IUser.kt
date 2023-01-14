package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.User

@Dao
interface IUser {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>
    @Query("SELECT * FROM user WHERE id = :id")
    fun findById(id: Int): User
    @Insert
    fun insertAll(vararg hist: User)
    @Delete
    fun delete(hist: User)
    @Update
    fun update(vararg hist: User)
}