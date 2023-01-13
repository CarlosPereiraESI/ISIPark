package com.example.isipark.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class UserHistory(val userID: Int, val historyID: Int) {
}*/

@Entity(tableName = "userHistory")
data class UserHistory(@PrimaryKey(autoGenerate = true) val userID: Int?,
                       val historyID: Int?) {
}