package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class VehiclesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles)

        val back = findViewById<Button>(R.id.profile_back_btn)
        val addMorebtn = findViewById<Button>(R.id.add_more_btn)

        //Back to dashboard page
        back.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        //Go to add vehicles page
        addMorebtn.setOnClickListener {
            val intent = Intent(this, Add_VehicleActivity::class.java)
            startActivity(intent)
        }

        //falta o adapter
    }

    override fun onBackPressed() {}
}