package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroLogin(@SerializedName("email") val email : String,
                 @SerializedName("password") val password : String) {
}