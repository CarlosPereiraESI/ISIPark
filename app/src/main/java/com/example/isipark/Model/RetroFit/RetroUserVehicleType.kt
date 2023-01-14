package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUserVehicleType(@SerializedName("utilizadorid") val userID: Int,
                                @SerializedName("Tipo_veiculosid_veiculo") val vehicleTypeID: Int,
                                @SerializedName("matricula") val licensePlate: String)
