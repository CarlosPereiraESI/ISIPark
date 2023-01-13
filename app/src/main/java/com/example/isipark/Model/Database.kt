package com.example.isipark.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.isipark.Model.Interfaces.IAdminMessage
import com.example.isipark.Model.Interfaces.IHistory

@Database(entities = arrayOf(AdminMessage::class, History::class), version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun iAdminMessage(): IAdminMessage
    abstract fun iHistory(): IHistory

    companion object {
        @Volatile
        private var instance: MyDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MyDatabase::class.java, "isipark.db"
        ).build()
    }
}