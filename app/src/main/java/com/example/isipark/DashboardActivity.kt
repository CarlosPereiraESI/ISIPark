package com.example.isipark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val codeBtn = findViewById<Button>(R.id.dashboard_code_btn)

        codeBtn.setOnClickListener {
            val intent = Intent(this@DashboardActivity, CodeActivity::class.java)
            startActivity(intent)
        }
    }
}