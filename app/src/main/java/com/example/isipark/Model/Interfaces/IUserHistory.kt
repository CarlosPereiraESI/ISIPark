package com.example.isipark.Model.Interfaces

import androidx.room.*
import com.example.isipark.Model.UserHistory

@Dao
interface IUserHistory {
    @Query("SELECT * FROM userHistory")
    fun getAll(): List<UserHistory>
    @Query("SELECT * FROM userHistory WHERE userID = :iduser AND historyID = :idhis" )
    fun findById(iduser: Int, idhis: Int): UserHistory
    @Insert
    fun insertAll(vararg usrhist: UserHistory)
    @Delete
    fun delete(usrhist: UserHistory)
    @Update
    fun update(vararg usrhist: UserHistory)
}