package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroPlace(@SerializedName("numero_lugar") var placeId : Int,
                      @SerializedName("setorid_setor") var idsetorSetor : Int,
                      @SerializedName("tipo_lugarn_tipo") var placeTypeID: Int,
                      @SerializedName("estado") var state: Boolean,
                      @SerializedName("utilizador_Tipo_veiculosmatricula") var licensePlate: String)
