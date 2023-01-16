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

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

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
