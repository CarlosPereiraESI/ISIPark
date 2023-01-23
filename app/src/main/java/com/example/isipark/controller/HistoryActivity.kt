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
import com.example.isipark.model.RetroFit.RetroHistory
import com.example.isipark.model.RetroFit.RetroSetorDis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val listView: ListView by lazy {
            findViewById<ListView>(R.id.dashboard_list_history)
        }
        val back = findViewById<Button>(R.id.history_back_btn)

        //Get id and token of this user
        val sp = getSharedPreferences(this@HistoryActivity)
        val token = sp.getString("token", null)
        val id = sp.getInt("id", 1)

        //Retrofit to get all history of this user
        Utils.instance.getAllHistoryUser(id, "Bearer $token")
            .enqueue(object: Callback<List<RetroHistory>> {
                override fun onResponse(call: Call<List<RetroHistory>>,
                                        response: Response<List<RetroHistory>>) {
                    if(response.code() == 200) {
                        val responseBody = response.body()
                        val adapter = responseBody?.let {
                            HistoryArrayAdapter(this@HistoryActivity, it)
                        }
                        listView.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<RetroHistory>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

        //Go back to profile page
        back.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
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