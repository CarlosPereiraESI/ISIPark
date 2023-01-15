package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class MoreOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_options)

        // Buttons page
        val parkingEdit = findViewById<Button>(R.id.more_parking_btn)
        val specialProfiles = findViewById<Button>(R.id.more_special_btn)
        val reportMessage = findViewById<Button>(R.id.more_report_btn)
        val searchUser = findViewById<Button>(R.id.more_search_btn)
        val logout = findViewById<Button>(R.id.more_logout_btn)
        val back = findViewById<Button>(R.id.more_back_btn)

        //Back button
        back.setOnClickListener {
            val intent = Intent(this, DashboardGestorActivity::class.java)
            startActivity(intent)
        }

        //Log Out button
        logout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        parkingEdit.setOnClickListener {
            val intent = Intent(this, ParkingEditActivity::class.java)
            startActivity(intent)
        }

        specialProfiles.setOnClickListener {
            val intent = Intent(this, SpecialProfileActivity::class.java)
            startActivity(intent)
        }

        //Go to page Repor Messages
        reportMessage.setOnClickListener {
            val intent = Intent(this@MoreOptionsActivity, ReportsMessagesActivity::class.java)
            startActivity(intent)
        }

        searchUser.setOnClickListener {
            val intent = Intent(this, SearchUsersActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {}
}