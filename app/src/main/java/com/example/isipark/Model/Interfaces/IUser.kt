package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.User

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