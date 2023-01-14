package com.example.isipark.Model.InterfacesRetroFit

import com.example.isipark.Model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.http.*

interface IRetroUser {

    @POST("api/Auth/login")
    fun login(@Body user: RetroUser): Call<RetroUser>

    @POST("api/Auth/register")
    fun insertAdminMessage(@Body user: RetroUser): Call<RetroUser>
}
