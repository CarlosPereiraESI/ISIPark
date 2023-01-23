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
import com.example.isipark.model.RetroFit.RetroLogin
import com.example.isipark.model.RetroFit.RetroSpecialProfile
import com.example.isipark.model.RetroFit.RetroUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpecialProfileActivity: AppCompatActivity() {

    var retroSP = RetroSpecialProfile(name="", licensePlate = "", contact = "", vehicleTypeID = 0, id = 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special_profiles)

        // Token
        val sp = getSharedPreferences(this@SpecialProfileActivity)
        val token = sp.getString("tokenA", null)

        //Buttons page
        val create = findViewById<Button>(R.id.create_btn)
        val back = findViewById<Button>(R.id.special_profile_back)
        val spinner = findViewById<Spinner>(R.id.addvehicletype_spinner)

        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
                listOf("normal", "eletric", "motorcycle", "reduce mobility"))
            spinner.adapter = adapter
        }

        if(spinner.selectedItem == "normal")
        {retroSP.vehicleTypeID = 1 }
        if(spinner.selectedItem == "eletric")
        {retroSP.vehicleTypeID = 2 }
        if(spinner.selectedItem == "motorcycle")
        {retroSP.vehicleTypeID = 3 }
        if(spinner.selectedItem == "reduce mobility")
        {retroSP.vehicleTypeID = 4 }


        //Fields
        val name = findViewById<EditText>(R.id.add_name_et)
        val registration = findViewById<EditText>(R.id.registration_et)
        val code = findViewById<EditText>(R.id.code_et)
        val date = findViewById<EditText>(R.id.exp_date_et)
        val contact = findViewById<EditText>(R.id.contact_et)


        // Button Create a special user
        create.setOnClickListener{

            if(name.text.toString() == "" || registration.text.toString() =="" || code.text.toString()==""
                || date.text.toString() == "" || contact.text.toString()==""){
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            } else {

                retroSP.name = name.text.toString()
                retroSP.licensePlate = registration.text.toString()
                retroSP.contact = contact.text.toString()
                retroSP.id = 0

                Utils.instance.insertSpecialUser(retroSP,"Bearer $token")
                    .enqueue(object: Callback<String> {
                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            if(response.code() == 201) {
                                val userInf = response.body()
                                val intent = Intent(this@SpecialProfileActivity,
                                    DashboardGestorActivity::class.java)
                                startActivity(intent)
                            }
                        }
                        override fun onFailure(call: Call<String>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }

        //Button Back
        back.setOnClickListener {
            val intent = Intent(this@SpecialProfileActivity, MoreOptionsActivity::class.java)
            startActivity(intent)
        }
    }

    //Don't go back without click on back button
    override fun onBackPressed() {}

    // Function to get token and id
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}
