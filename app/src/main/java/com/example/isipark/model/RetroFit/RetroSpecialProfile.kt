package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroSpecialProfile(@SerializedName("id") val id : Int,
                               @SerializedName("nome") val name: String,
                               @SerializedName("matricula") val licensePlate: String,
                               @SerializedName("contacto") val contact: String,
                               @SerializedName("Tipo_veiculosid_veiculo") val vehicleTypeID: Int
                               )
