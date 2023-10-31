package com.example.cl2.BookREST

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    val baseURL = "https://api.itbook.store/1.0/"

    fun getRetrofitInstance() : Retrofit {

        return Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build()

    }

}