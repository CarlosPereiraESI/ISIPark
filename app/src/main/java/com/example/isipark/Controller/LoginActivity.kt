package com.example.isipark.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val register = findViewById<Button>(R.id.login_create_btn)
        val login = findViewById<Button>(R.id.login_login_btn)

        val email = findViewById<EditText>(R.id.login_email_et)
        val password = findViewById<EditText>(R.id.login_password_et)


        register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            if ( email.text.toString() == "" || password.text.toString() == ""){
                Toast.makeText(this,"It has empty fields!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                startActivity(intent)
            }

            if (email.text.toString() == "admin@ipca.pt" && password.text.toString() == "1"){
                val intent = Intent(this@LoginActivity, DashboardGestorActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {}
}