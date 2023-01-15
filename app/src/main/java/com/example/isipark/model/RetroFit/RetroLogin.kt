package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroLogin(@SerializedName("email") val email : String,
                      @SerializedName("password") val password : String) {
}