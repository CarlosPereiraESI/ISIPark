package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUserHistory(@SerializedName("utilizadorid") val userID: Int,
                            @SerializedName("Historicoid") val historyID: Int)
