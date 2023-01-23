package com.example.isipark.model.RetroFit

import com.example.isipark.model.Constants.Companion.BASE_URL
import com.example.isipark.model.Interfaces.NotificationAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitInstance {

    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api by lazy {
            retrofit.create(NotificationAPI::class.java)
        }
    }
}