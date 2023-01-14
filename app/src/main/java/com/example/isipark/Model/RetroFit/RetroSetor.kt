package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroSetor(@SerializedName("id_setor") val id :Int,
                      @SerializedName("setor") val sectorName: String,
                      @SerializedName("total_lugares") val totalPlace: Int)
