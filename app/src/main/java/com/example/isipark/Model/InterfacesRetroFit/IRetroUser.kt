package com.example.isipark.Model.InterfacesRetroFit

import com.example.isipark.Model.RetroFit.RetroLogin
import com.example.isipark.Model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.http.*

interface IRetroUser {

    @POST("api/Auth/login")
    fun login(@Body login: RetroLogin): Call<RetroLogin>

    @POST("api/Auth/register")
    fun insertUser(@Body user: RetroUser): Call<RetroUser>
}
