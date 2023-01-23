package com.example.isipark.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/*
class Report(val id: Int, val description: String, val userID: Int,
             val date: Date, val licensePlate: String, val sector: String) {
}*/

@Entity(tableName = "report")
data class Report(@PrimaryKey(autoGenerate = true)val id: Int,
                  val description: String?, val userID: Int?,
                  val date: String?, val licensePlate: String?,
                  val sector: String?) {
}