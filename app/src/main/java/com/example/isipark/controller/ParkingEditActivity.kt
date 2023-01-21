package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParkingEditActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parking_edit)

        //Buttons page
        val add_map = findViewById<Button>(R.id.add_map_btn)
        val create = findViewById<Button>(R.id.create_park_btn)
        val back = findViewById<Button>(R.id.parking_edit_back)

        val sector = findViewById<EditText>(R.id.add_sector_et)
        val normal = findViewById<EditText>(R.id.normal_et)
        val motorcycle = findViewById<EditText>(R.id.motorcycle_et)
        val electrics = findViewById<EditText>(R.id.electrics_et)
        val red_mob = findViewById<EditText>(R.id.red_mob_et)

        val sp = getSharedPreferences(this@ParkingEditActivity)
        val token = sp.getString("token", null)

        // Button Create
        create.setOnClickListener {
            if (sector.text.toString() == "" || normal.text.toString() == ""
                || normal.text.toString() == "" || motorcycle.text.toString() == ""
                || electrics.text.toString() == "" || red_mob.text.toString() == "") {
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            } else {
                Utils.instance.createSector("Bearer $token")
                    .enqueue(object : Callback<Boolean> {
                        override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                            if (response.code() == 201) {
                            }
                        }

                        override fun onFailure(call: Call<Boolean>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
        // Button Add Map
        add_map.setOnClickListener{
        }

        //Button Back
        back.setOnClickListener {
            val intent = Intent(this@ParkingEditActivity,
                MoreOptionsActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {}

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}
