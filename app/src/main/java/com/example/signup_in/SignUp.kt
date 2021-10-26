package com.example.signup_in

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var location:EditText
    lateinit var mobile:EditText
    lateinit var pass:EditText
    lateinit var submit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        name=findViewById(R.id.edname)
        location=findViewById(R.id.edlocation)
        mobile=findViewById(R.id.edmobile)
        pass=findViewById(R.id.edpassword)
        submit=findViewById(R.id.btnsubmit)

       var dbobject= DBHlpr(applicationContext)


        submit.setOnClickListener {
            val s1=name.text.toString()
            val s2=location.text.toString()
            val s3=mobile.text.toString()
            val s4=pass.text.toString()
            if(s1.isNotEmpty()&&s2.isNotEmpty()&&s3.isNotEmpty()&&s4.isNotEmpty()){
            dbobject.save(s1, s2, s3, s4)

                val info=Intent(this,Details::class.java)
                info.putExtra("name",s1)
                info.putExtra("location",s2)
                info.putExtra("mobile",s3)
                startActivity(info)
        }
            else{
                Toast.makeText(applicationContext,"one or more field is empty",Toast.LENGTH_SHORT).show()
            }
    }
}}