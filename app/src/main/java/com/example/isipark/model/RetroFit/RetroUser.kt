package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUser(@SerializedName("id") var id: Int,
                     @SerializedName("nome") var name: String,
                     @SerializedName("nif") var nif: Int,
                     @SerializedName("dataNasc") var birthDate: String,
                     @SerializedName("genero") var gender: String,
                     @SerializedName("tipo_utilizadorid") var typeUserID: Int,
                     @SerializedName("moradaid_morada") var addressID: Int,
                     @SerializedName("email") var email: String,
                     @SerializedName("password") var password: String) {
}