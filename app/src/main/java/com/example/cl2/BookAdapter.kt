package com.example.cl2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val books: MutableList<LibrosViewModel>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.lblTitulo)
        val priceTextView: TextView = itemView.findViewById(R.id.lblPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.booklist,parent, false)
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {

        return books.size



    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val book = books[position]

        holder.titleTextView.text = book.title
        holder.priceTextView.text = book.price



    }

}