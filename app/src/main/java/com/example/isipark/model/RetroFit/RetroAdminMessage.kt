package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroAdminMessage(@SerializedName("id_mensagem") val id: Int,
                             @SerializedName("descricao") val desc: String,
                             @SerializedName("data") val date: String) {
}