package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.MyDatabase
import com.example.isipark.model.RetroFit.RetroLogin
import com.example.isipark.model.RetroFit.RetroUser
import com.example.isipark.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    var retrolog = RetroLogin(email="", password = "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*val user = User(id=0, name="", nif=0, birthDate="", gender="", typeUserID=0,
        addressID=0, email="", password="")
        val sp = getSharedPreferences(this@LoginActivity)
        val token = sp.getString("tokenA", null)*/

        /*
        val db = Room.databaseBuilder(applicationContext,
            MyDatabase::class.java, "isipark.db").build()
        GlobalScope.launch {
            Utils.instance.getAllUser("Bearer $token")
                .enqueue(object: Callback<List<RetroUser>> {
                    override fun onResponse(
                        call: Call<List<RetroUser>>,
                        response: Response<List<RetroUser>>) {
                        if (response.code() == 200) {
                            val data = response.body()
                            data?.forEach {
                                user.id = it.id
                                user.name = it.name
                                user.nif = it.nif
                                user.birthDate = it.birthDate
                                user.gender = it.gender
                                user.typeUserID = it.typeUserID
                                user.addressID = it.addressID
                                user.email = it.email
                                user.password = it.password
                                db.iUser().insertAll(user)
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<RetroUser>>, t: Throwable) {
                        Toast.makeText(
                            applicationContext, t.message,
                            Toast.LENGTH_LONG).show()
                    }
                })
        }*/

        val register = findViewById<Button>(R.id.login_create_btn)
        val login = findViewById<Button>(R.id.login_login_btn)

        val email = findViewById<EditText>(R.id.login_email_et)
        val password = findViewById<EditText>(R.id.login_password_et)

        //Go to register page
        register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        //Click on login button
        login.setOnClickListener {
            //See if there's no empty fields
            if (email.text.toString() == "" || password.text.toString() == "") {
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            }
            else{
                // If the user is the administrator
                if (email.text.toString() == "admin@ipca.pt" && password.text.toString() == "admin")
                {
                    retrolog.email = "admin@ipca.pt"
                    retrolog.password = "admin"

                    //Retrofit to validate the login
                    Utils.instance.login(retrolog)
                    .enqueue(object: Callback<String>{
                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            if(response.code() == 200){
                                Utils.instance.getUserID(retrolog.email)
                                    .enqueue(object: Callback<Int>{
                                        override fun onResponse(call: Call<Int>,
                                                                response: Response<Int>) {
                                            if(response.code() == 200){
                                                val idUser = response.body()
                                                val sap = getSharedPreferences(
                                                    this@LoginActivity)
                                                sap.edit().putInt("idA", idUser!!).apply()
                                            }
                                        }
                                        override fun onFailure(call: Call<Int>, t: Throwable) {
                                            Toast.makeText(applicationContext, t.message,
                                                Toast.LENGTH_LONG).show()
                                        }
                                    })
                                val loginbody = response.body()
                                Toast.makeText(applicationContext,"Welcome!",
                                    Toast.LENGTH_SHORT).show()

                                //Save the token
                                val sap = getSharedPreferences(this@LoginActivity)
                                sap.edit().putString("tokenA", loginbody).commit()

                                val intent = Intent(this@LoginActivity,
                                    DashboardGestorActivity::class.java)
                                startActivity(intent)
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
                // If the user is normal
                else
                {
                    retrolog.email = email.text.toString()
                    retrolog.password = password.text.toString()

                    Utils.instance.login(retrolog)
                        .enqueue(object: Callback<String>{
                            override fun onResponse(call: Call<String>,
                                                    response: Response<String>) {

                                if(response.code() == 200){

                                    Utils.instance.getUserID(retrolog.email)
                                        .enqueue(object: Callback<Int>{
                                            override fun onResponse(call: Call<Int>,
                                                                    response: Response<Int>) {
                                                if(response.code() == 200){
                                                    val idUser = response.body()
                                                    val sap = getSharedPreferences(
                                                        this@LoginActivity)
                                                    sap.edit().putInt("id", idUser!!).apply()
                                                }
                                            }
                                            override fun onFailure(call: Call<Int>, t: Throwable) {
                                                Toast.makeText(applicationContext, t.message,
                                                    Toast.LENGTH_LONG).show()
                                            }
                                        })

                                    val loginbody = response.body()
                                    Toast.makeText(applicationContext,"Welcome!",
                                        Toast.LENGTH_SHORT).show()
                                    //Save the token
                                    val sap = getSharedPreferences(this@LoginActivity)
                                    sap.edit().putString("token", loginbody).commit()

                                    val intent = Intent(this@LoginActivity,
                                        DashboardActivity::class.java)
                                    startActivity(intent)

                                }
                                if(response.code() == 400){
                                    Toast.makeText(applicationContext,"User Not Found",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                            override fun onFailure(call: Call<String>, t: Throwable) {
                                Toast.makeText(applicationContext, t.message,
                                    Toast.LENGTH_LONG).show()
                            }
                        })
                }
            }
        }
    }

    //Don't go back without click on back button
    override fun onBackPressed() {}

    //usar quando chamar os token
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
    }
}

