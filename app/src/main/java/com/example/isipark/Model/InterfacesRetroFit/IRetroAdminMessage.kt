package com.example.isipark.Model.InterfacesRetroFit

import com.example.isipark.Model.RetroFit.RetroAdminMessage
import retrofit2.Call
import retrofit2.http.*

interface IRetroAdminMessage {
    @GET("api/AdminMessage/getAll")
    fun getAllAdminMessage(@Header("Authorization") token: String): Call<List<RetroAdminMessage>>

    @POST("api/AdminMessage/insert")
    fun insertAdminMessage(@Header("Authorization") token: String,
                           @Body adminMessage: RetroAdminMessage): Call<RetroAdminMessage>
}
