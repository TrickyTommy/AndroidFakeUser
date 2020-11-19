package com.example.androiduserexcercise.util

import com.example.androiduserexcercise.services.DataServices
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utildata {
    private const val BASE_URL = "https://reqres.in/api/"

    val service: DataServices by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()

        retrofit.create(DataServices::class.java)
    }


}