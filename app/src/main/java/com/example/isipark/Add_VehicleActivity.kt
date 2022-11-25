package com.example.isipark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Add_VehicleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_vehicle)

        //Buttons page

            val save = findViewById<Button>(R.id.addVehicleSave)
            val back = findViewById<Button>(R.id.addVehicle_back)


            // Button Save
            save.setOnClickListener{
                val intent = Intent(this@Add_VehicleActivity,DashboardGestorActivity::class.java)
                startActivity(intent)
            }

            //Button back
            back.setOnClickListener {
                val intent = Intent(this@Add_VehicleActivity,DashboardGestorActivity::class.java)
                startActivity(intent)
            }


        }

    override fun onBackPressed() {}

}
