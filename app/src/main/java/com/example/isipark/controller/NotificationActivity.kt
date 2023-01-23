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
import android.widget.ListView
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroAdminMessage
import com.example.isipark.model.RetroFit.RetroUserMessageId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val back = findViewById<Button>(R.id.noti_back_btn)
        val listView = findViewById<ListView>(R.id.main_listview)

        //Get id and token of this user
        val sp = getSharedPreferences(this@NotificationActivity)
        val token = sp.getString("token", null)
        val id = sp.getInt("id", 1)

        //Retrofit to get all notifications
        Utils.instance.getNotificationUser(id,"Bearer $token")
            .enqueue(object: Callback<List<RetroUserMessageId>> {
                override fun onResponse(call: Call<List<RetroUserMessageId>>,
                                        response: Response<List<RetroUserMessageId>>){
                    if(response.code() == 200) {
                        val retroFit2 = response.body()
                        val adapter = retroFit2?.let {
                            NotificationUserAdapter(this@NotificationActivity, it)
                        }
                        listView.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<RetroUserMessageId>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        //Back button
        back.setOnClickListener {
            val intent = Intent(this@NotificationActivity, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    //Don't go back without click on back button
    override fun onBackPressed() {}

    // Function to get token and id
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}