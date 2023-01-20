package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUserVehicleType(@SerializedName("utilizadorid") var userID: Int,
                                @SerializedName("Tipo_veiculosid_veiculo") var vehicleTypeID: Int,
                                @SerializedName("matricula") var licensePlate: String)
