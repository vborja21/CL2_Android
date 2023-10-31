package com.example.cl2.BookREST

import retrofit2.Response
import retrofit2.http.GET

interface QuoteAPI {

    @GET("search/mongodb")
    suspend fun getQuotes(): Response<QuotesList>

}