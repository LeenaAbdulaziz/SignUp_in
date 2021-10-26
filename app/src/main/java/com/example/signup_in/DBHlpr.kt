package com.example.signup_in

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import android.widget.Toast.makeText

class DBHlpr(context: Context):SQLiteOpenHelper(context,"details",null,1) {
    val database:SQLiteDatabase=writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table users(name text,location text," +
                    "mobile text,password text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun save(s1:String,s2:String,s3:String,s4:String){
        val content=ContentValues()
        content.put("name",s1)
        content.put("location",s2)
        content.put("mobile",s3)
        content.put("password",s4)
        database.insert("users",null,content)



    }
    fun retrieve(name:String,mobile:String): Users? {
        val c:Cursor=database.query("users",null,"name=?",
            arrayOf(name),null,null,null)
        if(c.count<1){
            return null
        }
        c.moveToFirst()
        val user:Users
        val r= c.getString(c.getColumnIndex("mobile"))
        if(r==mobile){
            val loc=c.getString(c.getColumnIndex("location"))
            user= Users(name,loc,mobile)
            return user
        }
        else{

           return null
        }


    }
}