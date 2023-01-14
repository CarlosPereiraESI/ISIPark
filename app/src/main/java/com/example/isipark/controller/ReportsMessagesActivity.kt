package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class ReportsMessagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports_messages)

        val back = findViewById<Button>(R.id.report_back_btn)
        val send = findViewById<Button>(R.id.report_send_btn)

        //Go to send notification page
        send.setOnClickListener {
            val intent = Intent(this,SendNotificationActivity::class.java)
            startActivity(intent)
        }

        //Go back to more options menu
        back.setOnClickListener {
            val intent = Intent(this,MoreOptionsActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {}
}