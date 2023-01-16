package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.model.RetroFit.RetroLogin
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    var retrolog = RetroLogin(email="", password = "")
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
            if (email.text.toString() == "" || password.text.toString() == "") {
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            }
            else{
                retrolog.email = email.text.toString()
                retrolog.password = password.text.toString()
                Utils.instance.login(retrolog)
                    .enqueue(object: Callback<LoginResponse>{
                        override fun onResponse(call: Call<LoginResponse>,
                                                response: Response<LoginResponse>) {
                                val intent = Intent(this@LoginActivity,
                                    DashboardActivity::class.java)
                                startActivity(intent)
                        }
                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
            if (email.text.toString() == "admin@ipca.pt" && password.text.toString() == "admin") {
                val intent = Intent(
                    this@LoginActivity,
                    DashboardGestorActivity::class.java)
                startActivity(intent)
            }

        }
    }
    override fun onBackPressed() {}
}