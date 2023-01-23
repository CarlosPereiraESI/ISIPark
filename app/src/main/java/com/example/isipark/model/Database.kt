package com.example.isipark.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.isipark.model.Interfaces.IAdminMessage
import com.example.isipark.model.Interfaces.IHistory
import com.example.isipark.model.Interfaces.ISetor

@Database(entities = arrayOf(Setor::class), version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun iSetor(): ISetor

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