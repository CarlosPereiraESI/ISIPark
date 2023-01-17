package com.example.isipark.model.InterfacesRetroFit

import com.example.isipark.model.Interfaces.NetworkManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {

<<<<<<< HEAD
    private const val BASE_URL = "https://8403-2001-818-eb13-c00-5c2b-f9b9-99bf-81cf.eu.ngrok.io/"
=======
    private const val BASE_URL = "https://8403-2001-818-eb13-c00-5c2b-f9b9-99bf-81cf.eu.ngrok.io"
>>>>>>> bcd7f4732b4d8e8b450f643cb43d8d753277f72d

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