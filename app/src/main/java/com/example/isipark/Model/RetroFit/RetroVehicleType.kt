package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroVehicleType(@SerializedName("id_veiculo") val IdVehicle: Int,
                            @SerializedName("descricao") val description: String)
