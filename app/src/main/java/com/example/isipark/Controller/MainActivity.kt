package com.example.isipark.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.isipark.Model.AdminMessage
import com.example.isipark.Model.MyDatabase
import com.example.isipark.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val db = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, "isipark.db"
        ).build()
        GlobalScope.launch {
            //db.iAdminMessage().insertAll(AdminMessage(description= " ")
            val data = db.iAdminMessage().getAll()
            data?.forEach {
                println(it)
            }
        }
    }
}