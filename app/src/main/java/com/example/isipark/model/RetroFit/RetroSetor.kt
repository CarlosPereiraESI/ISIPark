package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroSetor(@SerializedName("iD_Setor") var id : Int,
                      @SerializedName("setor") var sectorName: String,
                      @SerializedName("total_Lugares") var totalPlace: Int)
