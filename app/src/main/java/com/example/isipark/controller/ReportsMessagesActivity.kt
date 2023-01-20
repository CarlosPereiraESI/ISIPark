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
import com.example.isipark.model.RetroFit.RetroReport
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReportsMessagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports_messages)

        val back = findViewById<Button>(R.id.report_back_btn)
        val send = findViewById<Button>(R.id.report_send_btn)
        val listView = findViewById<ListView>(R.id.listview_reports)

        val sp = getSharedPreferences(this@ReportsMessagesActivity)
        val token = sp.getString("tokenA", null)

        Utils.instance.getAllReports("Bearer $token")
            .enqueue(object: Callback<List<RetroReport>> {
                override fun onResponse(call: Call<List<RetroReport>>, response: Response<List<RetroReport>>){
                    if(response.code() == 200) {
                        val retroFit2 = response.body()
                        var adapter = retroFit2?.let {
                            ReportsMessageAdapter(this@ReportsMessagesActivity, it)
                        }
                        listView.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<RetroReport>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

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

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}