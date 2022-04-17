package com.example.login.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.login.R
import com.example.login.login.sign_in
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity(), View.OnClickListener {

    lateinit var mDatabase : DatabaseReference
    val mAuth = FirebaseAuth.getInstance()
    private lateinit var edtName : EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtconfrimmpass: EditText
    private lateinit var buttonSignUp: Button
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mDatabase =FirebaseDatabase.getInstance().getReference("Users")

        edtEmail = findViewById(R.id.email_regis)
        edtPassword = findViewById(R.id.password_regis)
        edtName = findViewById(R.id.name_regis)
        edtconfrimmpass = findViewById(R.id.confrimpass_regis)
        buttonBack = findViewById(R.id.button_back_regis)
        buttonSignUp = findViewById(R.id.button_sign_up_regis)

        buttonBack.setOnClickListener(this)
        buttonSignUp.setOnClickListener{
            signup()
        }
    }

    private fun signup(){
        val name        = edtName.text.toString()
        val email       = edtEmail.text.toString()
        val pass        = edtPassword.text.toString()
        val confrimpass = edtconfrimmpass.text.toString()

        if (name.isEmpty()){
            edtName.error = "Please Enter Your Name"
            edtName.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.text.toString()).matches()){
            edtEmail.error = "Please Enter Valid Email"
            edtEmail.requestFocus()
            return
        }

        if (pass.isEmpty()){
            edtPassword.error = "Please Enter Your Name"
            edtPassword.requestFocus()
            return
        }

        if(confrimpass.isEmpty() || pass != confrimpass){
            edtconfrimmpass.error = "Incorrect re-type password"
            edtconfrimmpass.requestFocus()
            return
        }

        if(!email.isEmpty() && !pass.isEmpty() && !name.isEmpty() && !confrimpass.isEmpty()){
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this,
            OnCompleteListener {task ->
                if (task.isSuccessful){
                    val user = mAuth.currentUser
                    val user_id = user!!.user_id
                    val url = "https://image.shutterstock.com/image-vector/chef-cooking-hat-vector-logo-260nw-1264315489.jpg"
                    val userData = user(name, url, null, null)
                }
            })
        }

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