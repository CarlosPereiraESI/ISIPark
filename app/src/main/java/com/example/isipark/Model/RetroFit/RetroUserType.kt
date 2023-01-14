package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUserType(@SerializedName("Id") val id : Int,
                         @SerializedName("nome_tipo") val type : String )
