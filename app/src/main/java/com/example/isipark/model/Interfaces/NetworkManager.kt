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
                           @Body adminMessage: RetroAdminMessage): Call<RetroAdminMessage>

    //Login
    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("api/Auth/login")
    fun login(@Body log: RetroLogin): Call<String>

    @POST("api/Auth/register")
    fun insertUser(user: RetroUser): Call<RetroUser>

    //Places
    @GET("api/Place/SetorType")
    fun getPlaceNormal(@Header("Authorization") token: String): Call<List<RetroPlaceFree>>

    @GET("api/Place/T/eletrico")
    fun getPlaceElectric(@Header("Authorization") token: String): Call<Int>

    @GET("api/Place/T/mota")
    fun getPlaceMotorcycle(@Header("Authorization") token: String): Call<Int>

    @GET("api/Place/T/necessidade especial")
    fun getPlaceRedMob(@Header("Authorization") token: String): Call<Int>

    //Get UserID by Email - Erro
    @GET("api/Auth/emailID/{email}")
    fun getUserID(@Query("email") email: String) : Call<Int>

    //Get Suggested Place - Incompleto
    @GET("api/Place/Setor")
    fun getSuggestedPlace(@Query("id") id: Int,
                          @Header("Authorization") token: String): Call<String>

    //Get User Profile
    @GET("api/User/{id}")
    fun getUser(@Query("id") id: Int) : Call<RetroUser>

    //Get User Vehicles
    @GET("api/UserVehicleType/{id}")
    fun getAllVehicles(@Query("id") id: Int) : Call<RetroVehicleType>
}