package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName
import java.util.Date

data class RetroUserMessageId(@SerializedName("descricao") var description: String,
                                @SerializedName("data") var date : String) {
}