package com.example.isipark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(@PrimaryKey(autoGenerate = true) var id: Int = 0,
                var name: String?, var nif: Int?, var birthDate: String?,
                var gender: String?, var typeUserID: Int?,
                var addressID: Int?, var email: String?,
                var password: String?) {
}