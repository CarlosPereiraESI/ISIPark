package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Add_VehicleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle)

        //Buttons page
        val save = findViewById<Button>(R.id.addVehicleSave)
        val back = findViewById<Button>(R.id.addVehicle_back)
        val spinner = findViewById<Spinner>(R.id.addvehicletype)
        val licensePlate = findViewById<EditText>(R.id.AddVehicleRegistration)

        //Get id and token of this user
        val sp = getSharedPreferences(this@Add_VehicleActivity)
        val token = sp.getString("token", null)
        val id = sp.getInt("id", 1)

        var X : Int? = null
        var typeVehicle : Int? = null

        //Pass the token to get all vehicle types
        Utils.instance.getTypeVehicles("Bearer $token")
            .enqueue(object: Callback<List<RetroTypeVehicle>> {
                override fun onResponse(call: Call<List<RetroTypeVehicle>>,
                                        response: Response<List<RetroTypeVehicle>>) {
                    if(response.code() == 200) {
                        val sug = response.body()

                        val tipos: MutableList<String> = mutableListOf()

                        if (sug != null) {
                            for (d in sug){
                                tipos.add(d.description)
                            }
                        }

                        if(spinner != null){
                            val adapter = ArrayAdapter(this@Add_VehicleActivity,
                                android.R.layout.simple_spinner_item, tipos)
                            spinner.adapter = adapter
                        }
                    }
                }
                override fun onFailure(call: Call<List<RetroTypeVehicle>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

        //Get the vehicle type selected
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View,
                                        position: Int, id: Long) {

                typeVehicle = position+1
                X = typeVehicle
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        // Button Save
        save.setOnClickListener{

            val retroSP = RetroUserVehicleType(userID=0, vehicleTypeID = 0, licensePlate = "")

            if (isValidLicensePlate(licensePlate.text.toString())==true){

                retroSP.userID=id
                retroSP.vehicleTypeID=typeVehicle!!
                retroSP.licensePlate= licensePlate.text.toString()

                // Enter the data to be added to the new vehicle
                    Utils.instance.insertVehicleUser(retroSP,"Bearer $token")
                        .enqueue(object: Callback<Boolean> {
                            override fun onResponse(call: Call<Boolean>,
                                                    response: Response<Boolean>) {
                                if(response.code() == 200) {
                                    val userInf = response.body()
                                    println("Feito com sucesso $userInf")

                                    val intent = Intent(this@Add_VehicleActivity,
                                        DashboardGestorActivity::class.java)
                                    startActivity(intent)
                                }
                            }
                            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                                Toast.makeText(applicationContext, t.message,
                                    Toast.LENGTH_LONG).show()
                            }
                        })

                val intent = Intent(this@Add_VehicleActivity,
                    VehiclesActivity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(this, "Registration Invalid ", Toast.LENGTH_LONG).show()
            }
        }

        //Button back
        back.setOnClickListener {
            val intent = Intent(this@Add_VehicleActivity,
                VehiclesActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to get token and id
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }

    //Function to validate a license plate
    fun isValidLicensePlate(plate: String): Boolean {
        val pattern = "(([A-Z]{2}|\\d{2})-([A-Z]{2}|\\d{2})-([A-Z]{2}|\\d{2}))".toRegex()
        return plate.matches(pattern)
    }

    //Don't go back without click on back button
    override fun onBackPressed() {}
}
