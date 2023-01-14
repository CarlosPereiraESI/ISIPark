package com.example.isipark.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/*
class PersonalData(val number: Int, val name: String, val CP4: Int,
                   val CP3: Int, val street: String, val contact: Int, val nif: Int,
                   val email: String, val password: String, val birthDate: Date,
                   val gender: String, val userType: String, val payment: Boolean,
                   val userID: Int) {
}*/

@Entity(tableName = "personalData")
data class PersonalData(@PrimaryKey(autoGenerate = true) val number: Int=0,
                     val name : String?, val CP4: Int?,
                        val CP3: Int?, val street: String?,
                        val contact: Int?, val nif: Int?,
                        val email: String?, val password: String?,
                        val birthDate: String?,
                        val gender: String?, val userType: String?,
                        val payment: Boolean?,
                        val userID: Int?) {
}