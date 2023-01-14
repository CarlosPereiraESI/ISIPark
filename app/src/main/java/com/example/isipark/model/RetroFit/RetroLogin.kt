package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroLogin(@SerializedName("email") var email : String,
                      @SerializedName("password") var password : String) {
}