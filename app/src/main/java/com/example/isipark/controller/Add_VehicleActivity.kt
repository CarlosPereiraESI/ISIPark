package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.isipark.R

class Add_VehicleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle)

        //Buttons page
        val save = findViewById<Button>(R.id.addVehicleSave)
        val back = findViewById<Button>(R.id.addVehicle_back)
        val spinner = findViewById<Spinner>(R.id.addvehicletype)

        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
                listOf("normal", "eletric", "motorcycle", "reduce mobility"))
            spinner.adapter = adapter
        }

        if(spinner.selectedItem == "normal")
        //{retroSP.vehicleTypeID = 1 }
        if(spinner.selectedItem == "eletric")
        //{retroSP.vehicleTypeID = 2 }
        if(spinner.selectedItem == "motorcycle")
        //{retroSP.vehicleTypeID = 3 }
        if(spinner.selectedItem == "reduce mobility")
        //{retroSP.vehicleTypeID = 4 }

        // Button Save
        save.setOnClickListener{
            val intent = Intent(this@Add_VehicleActivity, DashboardActivity::class.java)
            startActivity(intent)
        }

        //Button back
        back.setOnClickListener {
            val intent = Intent(this@Add_VehicleActivity, VehiclesActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {}
}
