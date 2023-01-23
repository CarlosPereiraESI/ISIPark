package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroAdminMessage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationAdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_admin)

        val listView = findViewById<ListView>(R.id.mainA_listview)
        val back = findViewById<Button>(R.id.notiA_back_btn)

        //Get id and token of this user
        val sp = getSharedPreferences(this@NotificationAdminActivity)
        val token = sp.getString("tokenA", null)

        //Retrofit to get all notifications
        Utils.instance.getnotifcationAdmin("Bearer $token")
            .enqueue(object: Callback<List<RetroAdminMessage>> {
                override fun onResponse(call: Call<List<RetroAdminMessage>>, response: Response<List<RetroAdminMessage>>){
                    if(response.code() == 200) {
                        val retroFit2 = response.body()
                        var adapter = retroFit2?.let {
                            NotificationAdminAdapter(this@NotificationAdminActivity, it)
                        }
                        listView.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<RetroAdminMessage>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

        //Back button
        back.setOnClickListener {
            val intent = Intent(this@NotificationAdminActivity, DashboardGestorActivity::class.java)
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