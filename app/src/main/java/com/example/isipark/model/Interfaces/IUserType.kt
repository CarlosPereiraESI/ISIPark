package com.example.isipark.model.Interfaces

import androidx.room.*
import com.example.isipark.model.UserType

@Dao
interface IUserType {
    @Query("SELECT * FROM userType")
    fun getAll(): List<UserType>
    @Query("SELECT * FROM userType WHERE id = :id ")
    fun findById(id: Int): UserType
    @Insert
    fun insertAll(vararg usrty: UserType)
    @Delete
    fun delete(usrty: UserType)
    @Update
    fun update(vararg usrty: UserType)
}