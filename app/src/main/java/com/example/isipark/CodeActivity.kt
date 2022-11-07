package com.example.isipark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        val backBtn = findViewById<Button>(R.id.code_back_btn)

        backBtn.setOnClickListener {
            val intent = Intent(this@CodeActivity, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}