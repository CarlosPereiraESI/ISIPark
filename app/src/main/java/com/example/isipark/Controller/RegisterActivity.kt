package com.example.isipark.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val createBtn = findViewById<Button>(R.id.register_create_btn)

        val email = findViewById<EditText>(R.id.register_email_et)
        val password = findViewById<EditText>(R.id.register_password_et)
        val confpassword =findViewById<EditText>(R.id.register_conf_password_et)


        createBtn.setOnClickListener {
            if ( email.text.toString() == "" || password.text.toString() == "" || confpassword.text.toString() == ""){
                Toast.makeText(this,"It has empty fields!", Toast.LENGTH_SHORT).show()
            }
            else{
                if(password.text.toString() == confpassword.text.toString()){
                    if (isCorrect(password.text.toString()) == true){
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"Invalid E-mail, try again!", Toast.LENGTH_SHORT).show()
                    }

                }
                else {
                    Toast.makeText(this, "The passwords don't match!", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    private fun isCorrect(string: String): Boolean {
        return string.matches("(([a-zA-Z0-9.])+[@][a-z]+[.][a-z]+)".toRegex())
    }

    override fun onBackPressed() {}
}