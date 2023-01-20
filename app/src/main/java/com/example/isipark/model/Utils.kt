package com.example.isipark.model.InterfacesRetroFit

import com.example.isipark.model.Interfaces.NetworkManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {


    private const val BASE_URL = "https://a738-2001-818-eb13-c00-3940-9f1e-492b-6f5d.eu.ngrok.io"



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