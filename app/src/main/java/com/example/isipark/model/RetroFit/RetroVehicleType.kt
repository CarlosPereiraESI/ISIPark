package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroVehicleType(@SerializedName("matricula") val licensePlate: String,
                            @SerializedName("descricao") val description: String)
