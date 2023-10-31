package com.example.cl2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cl2.BookREST.QuoteAPI
import com.example.cl2.BookREST.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val quotesAPI = RetrofitHelper.getRetrofitInstance().create(QuoteAPI::class.java)

        GlobalScope.launch {

            val response = quotesAPI.getQuotes()

            if(response.isSuccessful) {

                val books = response.body()?.books

                if(books != null) {

                    val bookList = mutableListOf<LibrosViewModel>()

                    for (book in books) {

                        val libroViewModel = LibrosViewModel (

                            image = R.mipmap.ic_launcher,
                            title = book.title,
                            price = book.price

                        )

                        bookList.add(libroViewModel)

                    }

                    runOnUiThread {

                        val recyclerView = findViewById<RecyclerView>(R.id.list_books)
                        recyclerView.layoutManager = LinearLayoutManager(this@BookActivity)
                        val adapter = BookAdapter(bookList)
                        recyclerView.adapter = adapter

                    }
                }

            } else {

                Log.e("BOOK ERROR: ", "ERROR EN LA CARGA")

            }
        }


    }
}