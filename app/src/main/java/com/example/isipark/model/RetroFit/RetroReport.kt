package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName
import java.util.*

data class RetroReport(@SerializedName("id_report") var id : Int,
                       @SerializedName("descricao") var description: String,
                       @SerializedName("utilizadorid") var userID: Int,
                       @SerializedName("data") var date: String,
                       @SerializedName("matricula") var licensePlate: String,
                       @SerializedName("setor") var sector: String

                       )
