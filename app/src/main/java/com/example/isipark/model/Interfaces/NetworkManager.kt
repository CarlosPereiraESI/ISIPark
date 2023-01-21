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

    //Login - Done
    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("api/Auth/login")
    fun login(@Body log: RetroLogin): Call<String>

    @POST("api/Auth/register")
    fun insertUser(user: RetroUser): Call<RetroUser>

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
    //noficacoes - Done
    @GET("api/AdminMessage/getAll")
    fun getnotifcationAdmin(@Header("Authorization") token: String): Call<List<RetroAdminMessage>>

    @GET("api/Place/T/necessidade especial")
    fun getPlaceRedMob(@Header("Authorization") token: String): Call<Int>


    //Get UserID by Email - Done
    @GET("api/Auth/emailID/{email}")
    fun getUserID(@Path("email") email: String) : Call<Int>

    //Get Suggested Place - Done
    @GET("api/Place/Setor/{id}")
    fun getSuggestedPlace(@Path("id") id: Int,
                        @Header("Authorization") token: String): Call<RetroSetorDis>

    //Get User Profile - Done
    @GET("api/User/{id}")
    fun getUser(@Path("id") id: Int,
                @Header("Authorization") token: String) : Call<RetroUser>


    //Get User Vehicles
    @GET("api/UserVechicleType/{id}")
    fun getAllVehicles(@Path("id") id: Int,
                       @Header("Authorization") token: String) :Call<List<RetroVehicleType>>

    //delete vehicle user
    @DELETE("api/UserVechicleType/plate/{plate}")
    fun deleteVehicle(@Path("plate") plate: String) : Call<String>

    //get type vehicle
    @GET("api/VehicleType/getAll")
    fun getTypeVehicles(@Header("Authorization") token: String) :Call<List<RetroTypeVehicle>>

    //add vehicle user
    @POST("api/UserVechicleType/insert")
    fun insertVehicleUser(@Body user: RetroUserVehicleType,
                          @Header("Authorization") token: String) : Call<Boolean>

    //notification User id
    @GET("api/UserMessage/user/{id}")
    fun getNotificationUser(@Path("id") id: Int,
                       @Header("Authorization") token: String) :Call<List<RetroUserMessageId>>

    //Get all History
    @GET("api/History/getAll")
    fun getAllHistory(@Header("Authorization") token: String): Call<List<RetroHistory>>

    //Get All History for a user
    @GET("api/History/{id}")
    fun getAllHistoryUser(@Path("id") id: Int,
                          @Header("Authorization") token: String) : Call<List<RetroHistory>>
    //Add a special User
    @POST("api/SpecialUsers/insert")
    fun insertSpecialUser(@Body user: RetroSpecialProfile,
                          @Header("Authorization") token: String) : Call<String>

    //Send a new report
    @POST("api/Report/insert")
    fun insertReport(@Body report: RetroReport,
                          @Header("Authorization") token: String) : Call<String>

    //Get all reports
    @GET("/api/Report/getAll")
    fun getAllReports(@Header("Authorization") token: String): Call<List<RetroReport>>

    //Create new sector
    @POST("/api/Setor/insert")
    fun createSector(@Body setor: RetroSetor,
                     @Header("Authorization") token: String) : Call<Boolean>
}