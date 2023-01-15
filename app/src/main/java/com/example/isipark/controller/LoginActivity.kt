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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            if (email.text.toString() == "" || password.text.toString() == "") {
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            }

            if (email.text.toString() == "admin@ipca.pt" && password.text.toString() == "admin") {
                val intent = Intent(
                    this@LoginActivity,
                    DashboardGestorActivity::class.java)
                startActivity(intent)
            }
            Utils.instance.login(email.text.toString(), password.text.toString())
                .enqueue(object: Callback<RetroLogin>{

                    override fun onFailure(call: Call<RetroLogin>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<RetroLogin>,
                        response: Response<RetroLogin>) {
                        if(response.code() == 200){
                            val intent = Intent(this@LoginActivity,
                                DashboardActivity::class.java)
                            startActivity(intent)
                        }
                    }
                })
        }
    }
<<<<<<< HEAD
=======


    val loginUrl = "api/Auth/login"

    val urlLogim = Utils.URL+loginUrl


    var retrofit = Retrofit.Builder()
        .baseUrl(Utils.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(IRetroUser::class.java)
    val call = service.login(userRequest).enqueue(object: Callback<RetroLogin> {
        override fun onResponse(call : Call<RetroLogin>,
                                response: Response<RetroLogin>){
            if(response.code() == 200){
                print("Hey")
                val intent = Intent(this@LoginActivity,
                    DashboardActivity::class.java)
                startActivity(intent)
            }
        }
        override fun onFailure(calll: Call<RetroLogin>, t: Throwable){
            print("error")
        }
    })
>>>>>>> 4bf8f77e05fe269ff3ca27d0ff090595ee5df9b8
    override fun onBackPressed() {}
}