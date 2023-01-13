package com.example.isipark.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.Model.Utils
import com.example.isipark.R

class CodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        val backBtn = findViewById<Button>(R.id.code_back_btn)

        // rota = /api/Auth/login
        // Utils.URL+rota
        //Utils.URL
        backBtn.setOnClickListener {
            val intent = Intent(this@CodeActivity, DashboardActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {}
}