package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUserType(@SerializedName("Id") val id : Int,
                         @SerializedName("nome_tipo") val type : String )
