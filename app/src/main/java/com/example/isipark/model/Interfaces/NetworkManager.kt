package com.example.isipark.model.Interfaces

import com.example.isipark.model.RetroFit.*
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

    //ROUTAS USER LUGARES LIVRES
    //todos utilizador
    @GET("api/Place/SetorType")
    fun getPlaceNormal(@Header("Authorization") token: String): Call<List<RetroPlaceFree>>

    //normal
    @GET("api/Place/SetorTypeNormal")
    fun getPlaceNormalLivre(@Header("Authorization") token: String): Call<List<RetroPlaceFree>>

    //motas
    @GET("api/Place/SetorTypeMoto")
    fun getPlaceMotasLivre(@Header("Authorization") token: String): Call<List<RetroPlaceFree>>

    //Eletrico
    @GET("api/Place/SetorTypeEletric")
    fun getPlaceElectricLivre(@Header("Authorization") token: String): Call<List<RetroPlaceFree>>

    //ReduceMob
    @GET("api/Place/SetorTypeReduceMob")
    fun getPlaceReduceLivre(@Header("Authorization") token: String): Call<List<RetroPlaceFree>>



    //ADMIN
    //noficacoes


    @GET("api/AdminMessage/getAll")
    fun getnotifcationAdmin(@Header("Authorization") token: String): Call<List<RetroAdminMessage>>
}