package com.example.isipark.model.RetroFit
import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("token") val token: String)