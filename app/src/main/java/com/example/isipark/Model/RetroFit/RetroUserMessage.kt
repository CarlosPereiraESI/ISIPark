package com.example.isipark.Model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUserMessage(@SerializedName("utilizadorid") val userID: Int,
                            @SerializedName("Mensagemid_mensagem") val messageID: Int)
