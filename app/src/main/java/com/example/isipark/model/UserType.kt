package com.example.isipark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
class UserType(val id: Int, val type: String) {
}*/

@Entity(tableName = "userType")
data class UserType(@PrimaryKey(autoGenerate = true) val id: Int=0,
                    val type: String?) {
}