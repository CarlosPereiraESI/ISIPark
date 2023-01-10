package com.example.isipark.Model

import java.util.Date

class User(val id: Int, val name: String, val nif: Int, val birthDate: Date,
            val gender: String, val typeUserID: Int, val addressID: Int, val email: String,
            val password: String, val passwordHash: String, val passwordSalt: String,
            var token: String) {
}