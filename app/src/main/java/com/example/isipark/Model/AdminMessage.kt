package com.example.isipark.Model

import androidx.room.*
import java.util.Date

@Entity(tableName = "adminMessage")
data class AdminMessage(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                        val description: String?, val date: String?) {
}
