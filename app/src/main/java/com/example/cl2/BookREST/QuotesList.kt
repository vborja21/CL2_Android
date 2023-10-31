package com.example.cl2.BookREST

data class QuotesList(

    val error : String,
    val total : String,
    val page: String,
    val books: List<Libros>


)