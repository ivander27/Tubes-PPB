package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button

class sign_in : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val button_signin: Button = findViewById(R.id.button_signin)
        val button_Register: Button = findViewById(R.id.button_register)

        button_signin.setOnClickListener(this)
        button_Register.setOnClickListener(this)
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

