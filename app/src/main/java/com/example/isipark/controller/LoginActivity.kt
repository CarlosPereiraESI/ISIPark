package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.model.InterfacesRetroFit.IRetroUser
import com.example.isipark.model.RetroFit.RetroLogin
import com.example.isipark.model.Utils
import com.example.isipark.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    var userRequest = RetroLogin("", "")
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
                userRequest.email = email.text.toString()
                userRequest.password = password.text.toString()
            }
            if (email.text.toString() == "admin@ipca.pt" && password.text.toString() == "admin"){
                val intent = Intent(this@LoginActivity,
                    DashboardGestorActivity::class.java)
                startActivity(intent)
            }
        }
    }

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
    override fun onBackPressed() {}
}