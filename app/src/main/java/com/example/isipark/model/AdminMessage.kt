package com.example.isipark.model

import androidx.room.*

@Entity(tableName = "adminMessage")
data class AdminMessage(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                        val description: String?, val date: String?) {
}
