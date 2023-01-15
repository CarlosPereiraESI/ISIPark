package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class SpecialProfileActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special_profiles)

        //Buttons page
        val create = findViewById<Button>(R.id.create_btn)
        val back = findViewById<Button>(R.id.special_profile_back)

        // Button Create
        create.setOnClickListener{
            val intent = Intent(this@SpecialProfileActivity, DashboardGestorActivity::class.java)
            startActivity(intent)
        }

        //Button Back
        back.setOnClickListener {
            val intent = Intent(this@SpecialProfileActivity, MoreOptionsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {}
}
