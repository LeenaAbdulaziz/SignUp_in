package com.example.signup_in

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    lateinit var edname:EditText
    lateinit var edmobile:EditText
    lateinit var signin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        edname=findViewById(R.id.edname2)
        edmobile=findViewById(R.id.edmobile2)
        signin=findViewById(R.id.signin)
        signin.setOnClickListener {
            val name=edname.text.toString()
            val mobile=edmobile.text.toString()
            if (name.isNotEmpty()&&mobile.isNotEmpty()){
                var dbobject=DBHlpr(applicationContext)
                val s= dbobject.retrieve(name,mobile)
                println(s)
              if(s!=null){
                  val info=Intent(this,Details::class.java)
                  info.putExtra("name",s.name)
                 info.putExtra("location",s.location)
                  info.putExtra("mobile",s.mobile)

                 startActivity(info)

              }else{
                 Toast.makeText(applicationContext,"something went wrong", Toast.LENGTH_SHORT).show()

              }

            }else{
                Toast.makeText(applicationContext,"one or more field empty", Toast.LENGTH_SHORT).show()

            }


        }

    }
}