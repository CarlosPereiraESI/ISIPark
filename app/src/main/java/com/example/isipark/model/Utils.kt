package com.example.isipark.model.InterfacesRetroFit

import com.example.isipark.model.Interfaces.NetworkManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {

<<<<<<< HEAD
    private const val BASE_URL = "https://1479-89-114-77-52.eu.ngrok.io/"
=======
    private const val BASE_URL = "https://0440-89-114-77-52.eu.ngrok.io/"


>>>>>>> 87afb74c1386b119289638bd79b6c6f8452194e9

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: NetworkManager by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(NetworkManager::class.java)
    }
}