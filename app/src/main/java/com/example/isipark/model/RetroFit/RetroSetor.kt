package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroSetor(@SerializedName("id_setor") val id :Int,
                      @SerializedName("setor") var sectorName: String,
                      @SerializedName("total_lugares") var totalPlace: Int)
