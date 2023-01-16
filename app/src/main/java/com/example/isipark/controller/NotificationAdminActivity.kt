package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.isipark.R

class NotificationAdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_admin)

        val back = findViewById<Button>(R.id.notiA_back_btn)

        //Back button
        back.setOnClickListener {
            val intent = Intent(this@NotificationAdminActivity, DashboardGestorActivity::class.java)
            startActivity(intent)
        }

        // Falta adapter para a listview das notificacoes
    }
    override fun onBackPressed() {}
}