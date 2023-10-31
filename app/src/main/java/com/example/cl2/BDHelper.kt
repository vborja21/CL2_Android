package com.example.cl2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDHelper (context : Context, factory: SQLiteDatabase.CursorFactory?)
    : SQLiteOpenHelper (context, DATABASE_NAME, factory, DATABASE_VERSION ) {

    companion object {

            private val DATABASE_NAME = "CL2_Libros"
            private val DATABASE_VERSION = 1
            private val TABLA_LIBRO = "LIBRO"
            private val COLUMN_ID = "ID"
            private val COLUMN_AUTOR = "AUTOR"
            private val COLUMN_LIBRO = "LIBRO"


    }

    override fun onCreate(db: SQLiteDatabase?) {
       var queryCreateTable =
           ( "CREATE TABLE " + TABLA_LIBRO + " ( " +
               COLUMN_ID + " INT PRIMARY KEY, " +
               COLUMN_AUTOR + " TEXT, " +
               COLUMN_LIBRO + " TEXT " + " )"
               )

      db?.execSQL(queryCreateTable)

    }

    fun RegistroLibros (autor:String, libro:String) {

        val values = ContentValues();

        values.put(COLUMN_AUTOR, autor)
        values.put(COLUMN_LIBRO, libro)

        val db = this.writableDatabase
        db.insert(TABLA_LIBRO, null, values)
        db.close()

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}