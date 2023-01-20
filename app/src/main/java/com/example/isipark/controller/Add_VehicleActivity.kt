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
        val licenseP = licensePlate.text.toString()

        println("ooooooooooooooooooolllllllllllllllllllllllllllllllllllllllllllaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        println(licensePlate)
        println(licenseP)

        val sp = getSharedPreferences(this@Add_VehicleActivity)
        val token = sp.getString("token", null)
        val id = sp.getInt("id", 1)

        var X : Int? = null
        var typeVehicle : Int? = null

        Utils.instance.getTypeVehicles("Bearer $token")
            .enqueue(object: Callback<List<RetroTypeVehicle>> {
                override fun onResponse(call: Call<List<RetroTypeVehicle>>, response: Response<List<RetroTypeVehicle>>) {
                    if(response.code() == 200) {
                        val sug = response.body()

                        val tipos: MutableList<String> = mutableListOf()

                        if (sug != null) {
                            for (d in sug){
                                tipos.add(d.description)
                                println(tipos.toString())
                            }
                        }

                        if(spinner != null){
                            val adapter = ArrayAdapter(this@Add_VehicleActivity, android.R.layout.simple_spinner_item, tipos)
                            spinner.adapter = adapter
                        }

                    }
                }
                override fun onFailure(call: Call<List<RetroTypeVehicle>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View,
                                        position: Int, id: Long) {

                typeVehicle = position+1
                println(typeVehicle)
                X = typeVehicle

            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

/*
        if(spinner.selectedItem == "normal")
        //{retroSP.vehicleTypeID = 1 }
        if(spinner.selectedItem == "eletric")
        //{retroSP.vehicleTypeID = 2 }
        if(spinner.selectedItem == "motorcycle")
        //{retroSP.vehicleTypeID = 3 }
        if(spinner.selectedItem == "reduce mobility")
        //{retroSP.vehicleTypeID = 4 }*/


println("ANTES DO SAVE ////////////////////////////////////////////////////////////////////////////////////")

        // Button Save

        save.setOnClickListener{

            println(X)
            var retroSP = RetroUserVehicleType(userID=0, vehicleTypeID = 0, licensePlate = "")

            if (isValidLicensePlate(licensePlate.text.toString())==true){
                //mandar para a base de dados

               /* fun importFromJSON(jsonObject: JSONObject): RetroUserVehicleType {
                    //val jsonObject = JSONObject(jsonString)
                    val id = jsonObject.getString("utilizadorid")
                    val typeVehicle = jsonObject.getString("Tipo_veiculosid_veiculo")
                    val licenseP = jsonObject.getString("matricula")
                    val post = RetroUserVehicleType(id, typeVehicle, licenseP)
                    println(post.toString())
                    return post
                }*/
                retroSP.userID=id
                retroSP.vehicleTypeID=typeVehicle!!
                retroSP.licensePlate= licensePlate.text.toString()

                println( retroSP.vehicleTypeID)
                println(retroSP.userID)
                println(retroSP.licensePlate)



                    Utils.instance.insertVehicleUser(retroSP,"Bearer $token")
                        .enqueue(object: Callback<Boolean> {
                            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                                if(response.code() == 200) {
                                    val userInf = response.body()
                                    println("Feito com sucesso $userInf")

                                    val intent = Intent(this@Add_VehicleActivity,
                                        DashboardGestorActivity::class.java)
                                    startActivity(intent)
                                }
                            }
                            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                            }
                        })






                val intent = Intent(this@Add_VehicleActivity, VehiclesActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Registration Invalid ",Toast.LENGTH_LONG).show()
            }

        }

        //Button back
        back.setOnClickListener {
            val intent = Intent(this@Add_VehicleActivity, VehiclesActivity::class.java)
            startActivity(intent)
        }
    }

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }


    fun isValidLicensePlate(plate: String): Boolean {
        val pattern = "(([A-Z]{2}|\\d{2})-([A-Z]{2}|\\d{2})-([A-Z]{2}|\\d{2}))".toRegex()
        return plate.matches(pattern)
    }
    override fun onBackPressed() {}
}
