package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class ParkingEditActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parking_edit)

        //Buttons page
        val add_map = findViewById<Button>(R.id.add_map_btn)
        val create = findViewById<Button>(R.id.create_park_btn)
        val back = findViewById<Button>(R.id.parking_edit_back)

        // Button Create
        create.setOnClickListener{
        }

        // Button Add Map
        add_map.setOnClickListener{
        }

        //Button Back
        back.setOnClickListener {
            val intent = Intent(this@ParkingEditActivity, MoreOptionsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {}
}
