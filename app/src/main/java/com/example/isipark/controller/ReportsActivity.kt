package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroReport
import com.example.isipark.model.RetroFit.RetroSpecialProfile
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class ReportsActivity : AppCompatActivity() {

    var retroR = RetroReport(id=0, description="", userID=0, date="", licensePlate="", sector="", name="")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        // Get fields of view
        val back = findViewById<Button>(R.id.report_back_btn)
        val send = findViewById<Button>(R.id.report_botao_send)

        val sector = findViewById<EditText>(R.id.report_setor_et)
        val registration = findViewById<EditText>(R.id.report_regisT)
        val more = findViewById<EditText>(R.id.report_more)

        //Get token and id from login
        val sp = getSharedPreferences(this@ReportsActivity)
        val token = sp.getString("token", null)
        val ap = getSharedPreferences(this@ReportsActivity)
        val id = ap.getInt("id", 0)

        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        val current = formatter.format(date)

        //Send a new Report
        send.setOnClickListener {
            if(sector.text.toString() == "" || registration.text.toString() =="" ||
                more.text.toString()==""){
                Toast.makeText(this, "It has empty fields!", Toast.LENGTH_SHORT).show()
            } else {

                retroR.id = 0
                retroR.sector = sector.text.toString()
                retroR.licensePlate = registration.text.toString()
                retroR.description = more.text.toString()
                retroR.userID = id
                retroR.date = current

                Utils.instance.insertReport(retroR,"Bearer $token")
                    .enqueue(object: Callback<String> {
                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            if(response.code() == 201) {
                                val userInf = response.body()
                                val intent = Intent(this@ReportsActivity,
                                    DashboardActivity::class.java)
                                startActivity(intent)
                            }
                        }
                        override fun onFailure(call: Call<String>, t: Throwable) {
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }

        //Back button
        back.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onBackPressed() {}

    //usar quando chamar os token
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}