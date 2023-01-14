package com.example.isipark.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val back = findViewById<Button>(R.id.noti_back_btn)

        //Back button
        back.setOnClickListener {
            val intent = Intent(this@NotificationActivity, DashboardActivity::class.java)
            startActivity(intent)
        }

        // Falta adapter para a listview das notificacoes
    }
    override fun onBackPressed() {}
}