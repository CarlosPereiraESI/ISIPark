package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroHistory(@SerializedName("id") val Id:Int,
                        @SerializedName("entrytime") val entryTime : String,
                        @SerializedName("exitTime") val exitTime : String,
                        @SerializedName("placeID") val placeID : Int)
