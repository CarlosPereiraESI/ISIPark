package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroPlaceFree(@SerializedName("setor") val setor: String,
                          @SerializedName("normal")val normal: String,
                          @SerializedName("eletrico") val eletric: String,
                          @SerializedName("motorcycle") val motorcycle: String,
                          @SerializedName("reduce_mob") val reduce_mob : String ){
}
