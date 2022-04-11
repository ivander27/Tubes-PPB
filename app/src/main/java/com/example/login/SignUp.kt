package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SignUp : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val buttonBack: Button = findViewById(R.id.button_back)
        val buttonSignUp: Button = findViewById(R.id.button_sign_up)

        buttonBack.setOnClickListener(this)
        buttonSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_back -> {
                val moveBack = Intent(this@SignUp, sign_in::class.java)
                startActivity(moveBack)
            }
            R.id.button_sign_up -> {
                val moveSignUp = Intent(this@SignUp, sign_in::class.java)
                startActivity(moveSignUp)
            }
        }
    }
}