package com.bitcode.a10_04_24_contentproviderdemo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class ProductsDBHelper(context: Context?,
    dbName : String,
    factory : SQLiteDatabase.CursorFactory?,
    version: Int): SQLiteOpenHelper(context,dbName,factory,version){

    override fun onCreate(db: SQLiteDatabase?) {
        Log.e("tag", "SQLiteOpenHelper.onCreate called")
        db!!.execSQL("create table products(id integer primary key,title text, price integer);")
        addProducts(db)
    }

    private fun addProducts(db : SQLiteDatabase?){
        var values = ContentValues()
        values.put("id",101)
        values.put("title","macbook")
        values.put("price",150000)

        var rownum = db!!.insert("products",null,values)

        var values1 = ContentValues()
        values1.put("id",102)
        values1.put("title","hp")
        values1.put("price",148000)

        var rownum1 = db!!.insert("products",null,values1)

        var values2 = ContentValues()
        values2.put("id",103)
        values2.put("title","asus")
        values2.put("price",139000)

        var rownum2 = db!!.insert("products",null,values2)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }
}