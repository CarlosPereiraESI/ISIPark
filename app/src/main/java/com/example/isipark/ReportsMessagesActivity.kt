package com.example.isipark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ReportsMessagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports_messages)

        val sendBtn = findViewById<Button>(R.id.report_send_btn)

        sendBtn.setOnClickListener {
            val intent = Intent(this, SendNotificationActivity::class.java)
            startActivity(intent)
        }

    }
}