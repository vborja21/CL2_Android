package com.example.cl2

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter (private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val autor : TextView = ItemView.findViewById(R.id.lblAutor)
        val libro : TextView = ItemView.findViewById(R.id.lblLibro)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_libros, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return mList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]

        val autorText = "Autor: ${item.autor}"
        val libroText = "Libro: ${item.libro}"

        holder.autor.text = autorText
        holder.libro.text = libroText

    }

}