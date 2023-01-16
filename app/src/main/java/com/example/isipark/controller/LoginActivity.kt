package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.model.RetroFit.RetroLogin
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
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
                    .enqueue(object: Callback<String>{
                        override fun onResponse(call: Call<String>,
                                                response: Response<String>) {

                            if(response.code() == 200){
                                val loginbody = response.body()
                                //val token = loginbody?.token

                                Toast.makeText(applicationContext,"Welcome!",
                                    Toast.LENGTH_SHORT).show()

                                val sp = getSharedPreferences(this@LoginActivity)
                                sp.edit().putString("token", loginbody).commit()

                                if (email.text.toString() == "admin@ipca.pt" &&
                                    password.text.toString() == "admin") {
                                    val intent = Intent(
                                        this@LoginActivity,
                                        DashboardGestorActivity::class.java)
                                    startActivity(intent)
                                }
                                else {
                                    val intent = Intent(this@LoginActivity,
                                        DashboardActivity::class.java)
                                    startActivity(intent)
                                }
                            }
                            if(response.code() == 400){
                                Toast.makeText(applicationContext,"User Not Found",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                        override fun onFailure(call: Call<String>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
    }
    override fun onBackPressed() {}

    //usar quando chamar os token
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
    }
}

