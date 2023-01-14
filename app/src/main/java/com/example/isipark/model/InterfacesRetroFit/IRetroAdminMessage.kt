package com.example.isipark.model.InterfacesRetroFit

import com.example.isipark.model.RetroFit.RetroAdminMessage
import retrofit2.Call
import retrofit2.http.*

interface IRetroAdminMessage {
    @GET("api/AdminMessage/getAll")
    fun getAllAdminMessage(@Header("Authorization") token: String): Call<List<RetroAdminMessage>>

    @POST("api/AdminMessage/insert")
    fun insertAdminMessage(@Header("Authorization") token: String,
                           @Body adminMessage: RetroAdminMessage): Call<RetroAdminMessage>
}
