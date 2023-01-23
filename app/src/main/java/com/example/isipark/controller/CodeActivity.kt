package com.example.isipark.controller

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroHistory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

<<<<<<< HEAD
        val sp = getSharedPreferences(this@CodeActivity)
        val token = sp.getString("token", null)
        val id = sp.getInt("id", 1)

        Utils.instance.getQRCode(id, "Bearer $token")
            .enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>,
                                        response: Response<String>) {
                    if(response.code() == 200) {
                        val responseBody = response.body()
                    }
                }
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

=======
        //Button back
>>>>>>> 251510b00bbca90c3dab2a58bb63948ec50fdccc
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

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name), Context.MODE_PRIVATE)
    }
}