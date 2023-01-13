package com.example.isipark.Model.Interfaces

import com.example.isipark.Model.RetroFit.RetroAdminMessage
import retrofit2.Call
import retrofit2.http.GET

interface IRetroAdminMessage {
    @GET("api/")
    fun getAllPosts(): Call<List<RetroAdminMessage>>
}
