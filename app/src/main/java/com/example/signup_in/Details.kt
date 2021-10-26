package com.example.signup_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Details : AppCompatActivity() {
    lateinit var tv:TextView
    lateinit var tv2:TextView
   lateinit var signout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        tv=findViewById(R.id.textView)
        tv2=findViewById(R.id.textView2)
        signout=findViewById(R.id.btnsignout)
        val name=intent.getStringExtra("name")
        val location=intent.getStringExtra("location")
        val mobile=intent.getStringExtra("mobile")
        val password=intent.getStringExtra("password")
       tv.text="Dear $mobile member"
        tv2.text="Name: $name  \n Location: $location"

     signout.setOnClickListener {
         startActivity(Intent(this,MainActivity::class.java))
     }
    }
}