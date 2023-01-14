package com.example.isipark.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class SendNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_notification)

        val back = findViewById<Button>(R.id.send_back_btn)
        val send_noti = findViewById<Button>(R.id.send_nofi_btn)

        back.setOnClickListener {
            val intent = Intent(this,ReportsMessagesActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {}
}