package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

class RetroTypeVehicle(@SerializedName("id_veiculo") val id: Int,
                       @SerializedName("descricao") val description: String) {
}