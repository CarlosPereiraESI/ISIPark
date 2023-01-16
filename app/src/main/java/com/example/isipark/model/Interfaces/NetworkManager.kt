package com.example.isipark.model.Interfaces

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

    //Places
    @GET("api/Place/T/normal")
    fun getPlaceNormal(@Header("Authorization") token: String): Call<Int>

    @GET("api/Place/T/eletrico")
    fun getPlaceElectric(@Header("Authorization") token: String): Call<Int>

    @GET("api/Place/T/mota")
    fun getPlaceMotorcycle(@Header("Authorization") token: String): Call<Int>

    @GET("api/Place/T/necessidade especial")
    fun getPlaceRedMob(@Header("Authorization") token: String): Call<Int>
}