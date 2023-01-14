package com.example.isipark.Model
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "history")
data class History(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                   val entryTime: String, val exitTime: String, val placeID: Int) {
}