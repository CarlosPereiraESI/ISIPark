package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroSpecialProfile(@SerializedName("id") var id : Int,
                               @SerializedName("nome") var name: String,
                               @SerializedName("matricula") var licensePlate: String,
                               @SerializedName("contacto") var contact: String,
                               @SerializedName("Tipo_veiculosid_veiculo") var vehicleTypeID: Int)
