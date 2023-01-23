package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.NotificationData
import com.example.isipark.model.PushNotification
import com.example.isipark.model.RetroFit.RetroFitInstance
import com.example.isipark.model.RetroFit.RetroLogin
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TOPIC = "/topics/myTopic"

class LoginActivity : AppCompatActivity() {
    var retrolog = RetroLogin(email="", password = "")
    val TAG = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        MyFirebaseMessagingService.sharedPref = getSharedPreferences(
            "sharedPref", Context.MODE_PRIVATE)
        FirebaseMessaging.getInstance().token.addOnSuccessListener {
            MyFirebaseMessagingService.token = it
         }
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)

        /*
        val set = Setor(id=0, sectorName="", totalPlace=0)
        val sp = getSharedPreferences(this@LoginActivity)
        val token = sp.getString("tokenA", null)

        val db = Room.databaseBuilder(applicationContext,
            MyDatabase::class.java, "isipark.db").build()
        GlobalScope.launch {
            Utils.instance.getAllSectors("Bearer $token")
                .enqueue(object : Callback<List<RetroSetor>> {
                    override fun onResponse(
                        call: Call<List<RetroSetor>>,
                        response: Response<List<RetroSetor>>) {
                        if (response.code() == 200) {
                            val data = response.body()
                            data?.forEach {
                                set.id = it.id
                                set.sectorName = it.sectorName
                                set.totalPlace = it.totalPlace
                                db.iSetor().insertAll(set)
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<RetroSetor>>, t: Throwable) {
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

        register.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            val title = "Welcome to ISIPark"
            val message = "You are logged in"

            if (email.text.toString() == "" || password.text.toString() == "") {
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            }
            else{
                // Se for administrador
                if (email.text.toString() == "admin@ipca.pt" && password.text.toString() == "admin")
                {
                    retrolog.email = "admin@ipca.pt"
                    retrolog.password = "admin"

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
                // Se for um user normal
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
                                    //val token = loginbody?.token

                                    Toast.makeText(applicationContext,"Welcome!",
                                        Toast.LENGTH_SHORT).show()
                                    PushNotification(NotificationData(title, message), TOPIC
                                    ).also {
                                        sendNotification(it)
                                    }
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
    override fun onBackPressed() {}

    //usar quando chamar os token
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
    }

    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO)
        .launch{
            try{
                val response = RetroFitInstance.api.postNotification(notification)
                if(response.isSuccessful) {
                    Log.d(TAG, "Response: ${Gson().toJson(response)}")
                } else{
                    Log.e(TAG, response.errorBody().toString())
                }
            } catch(e: Exception){
                Log.e(TAG, e.toString())
            }
        }
}

