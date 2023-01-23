package com.example.isipark.model

import android.app.Notification
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.isipark.model.Interfaces.IAdminMessage
import com.example.isipark.model.Interfaces.IHistory
import com.example.isipark.model.Interfaces.ISetor
import com.example.isipark.model.Interfaces.IUser

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)

abstract class MyDatabase: RoomDatabase() {
    abstract fun iUser(): IUser

    companion object {
        @Volatile
        private var instance: MyDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context, MyDatabase::class.java, "isipark.db").build()
    }
}