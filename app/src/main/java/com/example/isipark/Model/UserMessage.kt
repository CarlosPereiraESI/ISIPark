package com.example.isipark.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class UserMessage(val userID: Int, val messageID: Int) {
}*/

@Entity(tableName = "user")
data class UserMessage(@PrimaryKey(autoGenerate = true) val userID: Int=0,
                       val messageID: Int=0) {
}