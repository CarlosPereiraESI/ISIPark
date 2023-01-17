package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroHistory(@SerializedName("id") val Id:Int,
                        @SerializedName("hora_entrada") val entryTime : String,
                        @SerializedName("hora_saida") val exitTime : String,
                        @SerializedName("lugarnumero_lugar") val numberPlaces : Int)
