package com.example.isipark.model.InterfacesRetroFit

import com.example.isipark.model.Interfaces.NetworkManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {


<<<<<<< HEAD
    private const val BASE_URL = "https://c90a-94-61-246-109.eu.ngrok.io/"
=======
    private const val BASE_URL = "https://a738-2001-818-eb13-c00-3940-9f1e-492b-6f5d.eu.ngrok.io"
>>>>>>> fe8ef54b34d04c7f584f1ae30f8d2b39a05536b3

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