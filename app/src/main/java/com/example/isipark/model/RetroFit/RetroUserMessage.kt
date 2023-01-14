package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUserMessage(@SerializedName("utilizadorid") val userID: Int,
                            @SerializedName("Mensagemid_mensagem") val messageID: Int)
