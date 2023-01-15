package com.example.isipark.model.InterfacesRetroFit

import com.example.isipark.model.Interfaces.NetworkManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {

    private const val BASE_URL = "https://3959-2001-8a0-fe1a-c901-548-2f97-b065-a538.eu.ngrok.io/"

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