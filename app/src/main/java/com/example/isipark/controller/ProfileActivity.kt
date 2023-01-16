package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val back = findViewById<Button>(R.id.profile_back_btn)
        val vehiclesbtn = findViewById<Button>(R.id.profile_vehicle_btn)
        val historybtn = findViewById<Button>(R.id.profile_history_btn)
        val logoutbtn = findViewById<Button>(R.id.profile_logout)

        //Back to dashboard page
        back.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        //Go to vehicle page
        vehiclesbtn.setOnClickListener {
        }

        //Go to history page
        historybtn.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        //Logout
        logoutbtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //falta o adapter
    }

    override fun onBackPressed() {}
}