package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class sign_in : AppCompatActivity(), View.OnClickListener {
        private lateinit var emailfield: EditText
        private lateinit var passwordfield: EditText
        private lateinit var signinbutton: Button
        private lateinit var registerbutton: Button

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        Toast.makeText(this ,"firebase connection succes",Toast.LENGTH_LONG).show()

        emailfield = findViewById(R.id.email)
        passwordfield = findViewById(R.id.password)
        signinbutton = findViewById(R.id.button_signin)
        registerbutton = findViewById(R.id.button_register)

        var textUsername = emailfield.text
        var textPassword = passwordfield.text

        signinbutton.setOnClickListener{
            Log.e("Email", textUsername.toString())
            Log.e("Password", textPassword.toString())
        }
        registerbutton.setOnClickListener(this)
        }
        override fun onClick(v: View) {
            when (v.id) {
            R.id.button_signin -> {
                     val moveBack = Intent(this@sign_in, Home::class.java)
                     startActivity(moveBack)
                }
            R.id.button_register -> {
                     val moveSignUp = Intent(this@sign_in, SignUp::class.java)
                     startActivity(moveSignUp)
                }
            }
        }
    }

