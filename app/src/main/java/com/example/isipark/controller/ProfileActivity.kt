package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val back = findViewById<Button>(R.id.profile_back_btn)
        val vehiclesbtn = findViewById<Button>(R.id.profile_vehicle_btn)
        val historybtn = findViewById<Button>(R.id.profile_history_btn)
        val logoutbtn = findViewById<Button>(R.id.profile_logout)

        val name = findViewById<TextView>(R.id.name)
        val number = findViewById<TextView>(R.id.number)
        val email = findViewById<TextView>(R.id.email)
        val userType = findViewById<TextView>(R.id.userType)

        val sp = getSharedPreferences(this@ProfileActivity)
        val token = sp.getString("token", null)
        val ap = getSharedPreferences(this@ProfileActivity)
        val id = ap.getInt("id", 0)



        Utils.instance.getUser(id, "Bearer $token")
            .enqueue(object: Callback<RetroUser> {
                override fun onResponse(call: Call<RetroUser>, response: Response<RetroUser>) {
                    if(response.code() == 200) {
                        val userInf = response.body()
                        name.text = "Name: " + userInf?.name
                        number.text = "Number: " + id.toString()
                        email.text ="Email: " + userInf?.email
                        if (userInf?.typeUserID == 1){
                            userType.text = "User Type: Student"
                        }
                        if (userInf?.typeUserID == 2){
                            userType.text = "Type: Teacher"
                        }
                        if (userInf?.typeUserID == 3){
                            userType.text = "Type: Staff"
                        }

                    }
                }
                override fun onFailure(call: Call<RetroUser>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

        //Back to dashboard page
        back.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        //Go to vehicle page
        vehiclesbtn.setOnClickListener {
            val intent = Intent(this, VehiclesActivity::class.java)
            startActivity(intent)
        }

        //Go to history page
        historybtn.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        //Logout
        logoutbtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //falta o adapter
    }

    override fun onBackPressed() {}

    //usar quando chamar os token
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}