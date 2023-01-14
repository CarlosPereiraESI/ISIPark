package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName
import java.util.*

class RetroPersonData(@SerializedName("numero") val number : Int,
                      @SerializedName("nome") val name : String,
                      @SerializedName("cp4") val CP4: Int,
                      @SerializedName("cp3") val CP3: Int,
                      @SerializedName("rua") val street: String,
                      @SerializedName("contacto") val contact: Int,
                      @SerializedName("nif") val nif: Int,
                      @SerializedName("email") val email: String,
                      @SerializedName("password") val password: String,
                      @SerializedName("dataNasc") val birthDate: Date,
                      @SerializedName("genero") val gender: String,
                      @SerializedName("tipo_utilizador") val userType: String,
                      @SerializedName("pagamento") val payment: Boolean,
                      @SerializedName("utilizadornif") val userID: Int) {
}