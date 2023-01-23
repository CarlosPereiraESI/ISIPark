package com.example.isipark.controller

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.isipark.R

class CodeActivity : AppCompatActivity() {
    private var CHANNEL_ID = "Channel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        //Send a push notification
        CreateNotificationChannel()
        val notificationLayout = RemoteViews(packageName, R.layout.activity_push_notification)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("ISIPark")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(notificationLayout)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val backBtn = findViewById<Button>(R.id.code_back_btn)

        //Button back
        backBtn.setOnClickListener {
            with(NotificationManagerCompat.from(this)) {
                notify(0, builder.build())
            }
            val intent = Intent(this@CodeActivity, DashboardActivity::class.java)
            startActivity(intent)
        }

    }
    private fun CreateNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "ISIPark Notification"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply{
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(
                Context
                .NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    //Don't go back without click on back button
    override fun onBackPressed() {}
}