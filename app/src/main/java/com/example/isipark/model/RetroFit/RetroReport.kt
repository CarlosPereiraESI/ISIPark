package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName
import java.util.*

data class RetroReport(@SerializedName("id_report") val id : Int,
                       @SerializedName("descricao") val description: String,
                       @SerializedName("utilizadorid") val userID: Int,
                       @SerializedName("data") val date: Date,
                       @SerializedName("matricula") val licensePlate: String,
                       @SerializedName("setor") val sector: String

                       )
