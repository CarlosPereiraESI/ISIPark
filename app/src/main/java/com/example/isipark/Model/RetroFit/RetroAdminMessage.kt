package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName
import java.util.*

data class RetroAdminMessage(@SerializedName("id_mensagem") val id: Int,
                             @SerializedName("descricao") val desc: String,
                             @SerializedName("data") val date: Date) {
}