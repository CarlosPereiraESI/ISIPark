package com.example.isipark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MoreOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_options)

        // Buttons page
        val parkingEdit = findViewById<Button>(R.id.more_parking_btn)
        val newEntries = findViewById<Button>(R.id.more_new_btn)
        val addVehicle = findViewById<Button>(R.id.more_addv_btn)
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

        parkingEdit.setOnClickListener {  }
        newEntries.setOnClickListener {  }
        addVehicle.setOnClickListener {  }
        specialProfiles.setOnClickListener {  }
        reportMessage.setOnClickListener {  }
        searchUser.setOnClickListener {  }
    }

    override fun onBackPressed() {}
}