package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroVehicleType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class VehiclesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)

        val listView: ListView by lazy {
            findViewById<ListView>(R.id.list_vehicles)
        }

        val back = findViewById<Button>(R.id.profile_back_btn)
        val addMorebtn = findViewById<Button>(R.id.add_more_btn)

        val sp = getSharedPreferences(this@VehiclesActivity)
        val token = sp.getString("token", null)
        val id = sp.getInt("id", 1)

        //Back to dashboard page
        back.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        //Go to add vehicles page

            Utils.instance.getAllVehicles(id, "Bearer $token")
                .enqueue(object: Callback<List<RetroVehicleType>> {
                    override fun onResponse(call: Call<List<RetroVehicleType>>,
                                            response: Response<List<RetroVehicleType>>
                    ) {
                        if(response.code() == 200) {
                            val responseBody = response.body()
                            val adapter = responseBody?.let {
                                VehicleArrayAdapMyVehicle(this@VehiclesActivity, it)
                            }
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroVehicleType>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })

        addMorebtn.setOnClickListener {

            val intent = Intent(this, Add_VehicleActivity::class.java)
            startActivity(intent)
        }
    }

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }

    override fun onBackPressed() {}
}