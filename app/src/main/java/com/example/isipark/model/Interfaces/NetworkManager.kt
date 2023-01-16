package com.example.isipark.model.Interfaces

import com.example.isipark.model.RetroFit.LoginResponse
import com.example.isipark.model.RetroFit.RetroAdminMessage
import com.example.isipark.model.RetroFit.RetroLogin
import com.example.isipark.model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.http.*

interface NetworkManager {

    //Admin Messages
    @GET("api/AdminMessage/getAll")
    fun getAllAdminMessage(@Header("Authorization") token: String): Call<List<RetroAdminMessage>>

    @POST("api/AdminMessage/insert")
    fun insertAdminMessage(@Header("Authorization") token: String,
                           @Body adminMessage: RetroAdminMessage
    ): Call<RetroAdminMessage>

    //Login
    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("api/Auth/login")
    fun login(@Body log: RetroLogin): Call<String>

    @POST("api/Auth/register")
    fun insertUser( user: RetroUser): Call<RetroUser>
}