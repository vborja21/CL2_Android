package com.example.cl2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RegistroLibros : AppCompatActivity() {

   private val mList: MutableList<ItemsViewModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_libros)


        val recyclerView = findViewById<RecyclerView>(R.id.list_libros)
        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager


        val customAdapter = CustomAdapter(mList)
        recyclerView.adapter = customAdapter


        val btnCrear : Button = findViewById(R.id.btnCrear)
        val btnLimpiar : Button = findViewById(R.id.btnLimpiar)

        btnCrear.setOnClickListener {

            val inputAutor : EditText = findViewById(R.id.txtAutor)
            val inputLibro : EditText = findViewById(R.id.txtLibro)



            val autor = inputAutor.text.toString()
            val libro = inputLibro.text.toString()

            val newItem = ItemsViewModel(autor, libro)

            mList.add(newItem)

            customAdapter.notifyDataSetChanged()



            val db = BDHelper (this, null)

        db.RegistroLibros(autor, libro)

            Toast.makeText(this, "Se creo el libro de manera exitosa", Toast.LENGTH_LONG).show()

            inputLibro.text.clear()
            inputAutor.text.clear()
        }

        btnLimpiar.setOnClickListener {

            val inputAutor: EditText = findViewById(R.id.txtAutor)
            val inputLibro: EditText = findViewById(R.id.txtLibro)


            inputLibro.text.clear()
            inputAutor.text.clear()

        }

        val btnLibro: Button = findViewById(R.id.btnLibros)

        btnLibro.setOnClickListener {

            val pantallaLibro = Intent (this, BookActivity::class.java)
            startActivity(pantallaLibro)

        }


    }
}