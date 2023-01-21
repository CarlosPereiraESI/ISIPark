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
import com.example.isipark.model.RetroFit.RetroPlace
import com.example.isipark.model.RetroFit.RetroSetor
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
        val token = sp.getString("tokenA", null)

        // Button Create
        create.setOnClickListener {
            val retroSector = RetroSetor(id = 0, sectorName = "", totalPlace = 0)
            val retroPlace = RetroPlace(placeId = 0, idsetorSetor = 0, placeTypeID = 0,
                                        state = false, licensePlate = "")

            var responseBody = 0
            retroSector.sectorName = sector.text.toString()
            retroSector.totalPlace = normal.text.toString().toInt() +
                    motorcycle.text.toString().toInt() +
                    electrics.text.toString().toInt() +
                    red_mob.text.toString().toInt()

            if (sector.text.toString() == "" || normal.text.toString() == ""
                || normal.text.toString() == "" || motorcycle.text.toString() == ""
                || electrics.text.toString() == "" || red_mob.text.toString() == "") {
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            } else {
                Utils.instance.createSector(retroSector,"Bearer $token")
                    .enqueue(object : Callback<Int> {
                        override fun onResponse(call: Call<Int>, response: Response<Int>) {
                            if (response.code() == 200) {
                                responseBody = response.body()!!
                                println("HEEEH" + responseBody)
                                Toast.makeText(
                                    this@ParkingEditActivity,
                                    "Created New Sector! ", Toast.LENGTH_LONG).show()
                            }

                        }

                        override fun onFailure(call: Call<Int>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }
                    })

                for(i in 1..normal.text.toString().toInt()){
                    retroPlace.idsetorSetor = responseBody
                    retroPlace.placeTypeID = 1
                    retroPlace.state = false
                    retroPlace.licensePlate = null
                    Utils.instance.createPlaces(retroPlace, "Bearer $token")
                        .enqueue(object: Callback<Boolean> {
                            override fun onResponse(call: Call<Boolean>,
                                                    response: Response<Boolean>) {
                            }

                            override fun onFailure(call: Call<Boolean>,
                                                   t: Throwable) {
                                Toast.makeText(applicationContext,
                                    t.message, Toast.LENGTH_LONG).show()
                            }
                        })
                }

                for(i in 1..electrics.text.toString().toInt()){
                    retroPlace.idsetorSetor = responseBody
                    retroPlace.placeTypeID = 2
                    retroPlace.state = false
                    retroPlace.licensePlate = null
                    Utils.instance.createPlaces(retroPlace, "Bearer $token")
                        .enqueue(object: Callback<Boolean> {
                            override fun onResponse(call: Call<Boolean>,
                                                    response: Response<Boolean>) {
                            }

                            override fun onFailure(call: Call<Boolean>,
                                                   t: Throwable) {
                                Toast.makeText(applicationContext,
                                    t.message, Toast.LENGTH_LONG).show()
                            }
                        })
                }

                for(i in 1..motorcycle.text.toString().toInt()){
                    retroPlace.idsetorSetor = responseBody
                    retroPlace.placeTypeID = 3
                    retroPlace.state = false
                    retroPlace.licensePlate = null
                    Utils.instance.createPlaces(retroPlace, "Bearer $token")
                        .enqueue(object: Callback<Boolean> {
                            override fun onResponse(call: Call<Boolean>,
                                                    response: Response<Boolean>) {
                            }

                            override fun onFailure(call: Call<Boolean>,
                                                   t: Throwable) {
                                Toast.makeText(applicationContext,
                                    t.message, Toast.LENGTH_LONG).show()
                            }
                        })
                }

                for(i in 1..red_mob.text.toString().toInt()){
                    retroPlace.idsetorSetor = responseBody
                    retroPlace.placeTypeID = 4
                    retroPlace.state = false
                    retroPlace.licensePlate = null
                    Utils.instance.createPlaces(retroPlace, "Bearer $token")
                        .enqueue(object: Callback<Boolean> {
                            override fun onResponse(call: Call<Boolean>,
                                                    response: Response<Boolean>) {
                            }

                            override fun onFailure(call: Call<Boolean>,
                                                   t: Throwable) {
                                Toast.makeText(applicationContext,
                                    t.message, Toast.LENGTH_LONG).show()
                            }
                        })
                }
            }
            sector.text.clear()
            normal.text.clear()
            motorcycle.text.clear()
            electrics.text.clear()
            red_mob.text.clear()
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
