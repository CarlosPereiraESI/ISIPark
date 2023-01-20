package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroPlaceFree
import com.example.isipark.model.RetroFit.RetroSetorDis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    val listView: ListView by lazy{
        findViewById<ListView>(R.id.dashboard_list_sectors)
    }
/*
    val valuesN = mutableListOf<sector>(sector("Sector T", "Normal: 50", "", "", ""), sector("Sector D", "Normal: 20", "", "", ""), sector("Sector G", "Normal: 10", "", "", ""))
    val valuesM = mutableListOf<sector>(sector("Sector T", "Normal: 50", "", "Motorcycle: 10", ""), sector("Sector D", "Normal: 20", "", "Motorcycle: 5", ""), sector("Sector G", "Normal: 10", "", "Motorcycle: 1", ""))
    val valuesE = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "", ""), sector("Sector D", "Normal: 20", "Eletric: 1", "", ""), sector("Sector G", "Normal: 10", "Eletric: 0", "", ""))
    val valuesR = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "", "R.Mobility: 1"), sector("Sector D", "Normal: 20", "Eletric: 1", "", "R.Mobility: 0"), sector("Sector G", "Normal: 10", "Eletric: 0", "", "R.Mobility: 2"))
*/
    //var normal: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        //---------------------------- Buttons -------------------------------------

        //Report button
        val report = findViewById<ImageButton>(R.id.dashboard_report)
        val suggested_place = findViewById<TextView>(R.id.dashboard_suggestion2_et)

        //Notification button
        val notification = findViewById<ImageButton>(R.id.dashboard_notification)

        //Code button
        val profile = findViewById<Button>(R.id.dashboard_profile_btn)
        val codeBtn = findViewById<Button>(R.id.dashboard_code_btn)

        //Vehicle buttons
        val normalBtn = findViewById<ImageButton>(R.id.normal)
        val motoBtn = findViewById<ImageButton>(R.id.moto)
        val eletricBtn = findViewById<ImageButton>(R.id.eletric)
        val rmobBtn = findViewById<ImageButton>(R.id.rmob)

        val sp = getSharedPreferences(this@DashboardActivity)
        val token = sp.getString("token", null)
        val id = sp.getInt("id", 1)

        Utils.instance.getSuggestedPlace(id, "Bearer $token")
        .enqueue(object: Callback<RetroSetorDis>{
            override fun onResponse(call: Call<RetroSetorDis>, response: Response<RetroSetorDis>) {
                if(response.code() == 200) {
                    val sug = response.body()
                    suggested_place.text = sug?.setor

                }
            }
            override fun onFailure(call: Call<RetroSetorDis>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

        Utils.instance.getPlaceNormal("Bearer $token")
            .enqueue(object: Callback<List<RetroPlaceFree>> {
                override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                    if(response.code() == 200) {
                        val retroFit2 = response.body()
                        var adapter = retroFit2?.let {
                            VehiclesArrayAdapter(this@DashboardActivity, it)
                        }

                        //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                        listView.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        //--------------------------- Adapter ------------------------------



        // ------------------------- Click buttons ------------------------------------

        //Show reports page
        report.setOnClickListener{
            val intent = Intent(this@DashboardActivity, ReportsActivity::class.java)
            startActivity(intent)
        }

        //Show notification page
        notification.setOnClickListener{
            val intent = Intent(this@DashboardActivity,
                NotificationActivity::class.java)
            startActivity(intent)
        }

        //Show profile page
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        //Show code page
        codeBtn.setOnClickListener {
            val intent = Intent(this@DashboardActivity, CodeActivity::class.java)
            startActivity(intent)
        }


        //Show normal places on dashboard
        normalBtn.setOnClickListener{
            Utils.instance.getPlaceNormalLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardActivity, it)
                            }
                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })
        }

        //Show motocycle places on dashboard
        motoBtn.setOnClickListener{
            Utils.instance.getPlaceMotasLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardActivity, it)
                            }
                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })
        }

        //Show eletric places on dashboard
        eletricBtn.setOnClickListener{
//getPlaceElectricLivre
            Utils.instance.getPlaceElectricLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardActivity, it)
                            }
                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })

        }

        //Show reduce mobility places on dashboard
        rmobBtn.setOnClickListener{
   //getPlaceReduceLivre
            Utils.instance.getPlaceReduceLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardActivity, it)
                            }
                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })

        }
    }

    override fun onBackPressed() {}

    //usar quando chamar os token
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }
}