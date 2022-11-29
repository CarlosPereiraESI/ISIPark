package com.example.isipark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SendNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_notification)

        val back = findViewById<Button>(R.id.send_noti_back_btn)

        back.setOnClickListener {
            val intent = Intent(this, ReportsMessagesActivity::class.java)
            startActivity(intent)
        }
    }
}