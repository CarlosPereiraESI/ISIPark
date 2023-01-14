package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroPlace(@SerializedName("setorid_setor") val  idsetorSetor : Int,
                      @SerializedName("tipo_lugarn_tipo") val placeTypeID: Int,
                      @SerializedName("estado") val state: Boolean,
                      @SerializedName("utilizador_Tipo_veiculosmatricula") val licensePlate: String)
