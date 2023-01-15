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
    @FormUrlEncoded
    @POST("api/Auth/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String): Call<RetroLogin>

    @POST("api/Auth/register")
    fun insertUser(@Body user: RetroUser): Call<RetroUser>
}