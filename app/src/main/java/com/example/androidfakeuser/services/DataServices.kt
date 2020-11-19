package com.example.androiduserexcercise.services

import com.example.androiduserexcercise.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface DataServices {
    @GET("users")
    fun getAllProduct(): Call<ResponseData>
}