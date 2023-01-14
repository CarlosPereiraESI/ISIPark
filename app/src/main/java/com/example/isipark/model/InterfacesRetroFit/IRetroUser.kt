package com.example.isipark.model.InterfacesRetroFit

import com.example.isipark.model.RetroFit.RetroLogin
import com.example.isipark.model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.http.*

interface IRetroUser {

    @POST("api/Auth/login")
    fun login(@Body login: RetroLogin): Call<RetroLogin>

    @POST("api/Auth/register")
    fun insertUser(@Body user: RetroUser): Call<RetroUser>
}
