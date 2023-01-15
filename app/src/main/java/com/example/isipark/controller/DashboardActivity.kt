package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import com.example.isipark.R
import com.example.isipark.model.sector

class DashboardActivity : AppCompatActivity() {

    val listView: ListView by lazy{
        findViewById<ListView>(R.id.dashboard_list_sectors)
    }

    val values = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "Motorcycle: 10", "R.Mobility: 1"), sector("Sector D", "Normal: 20", "Eletric: 1", "Motorcycle: 5", "R.Mobility: 0"), sector("Sector G", "Normal: 10", "Eletric: 0", "Motorcycle: 1", "R.Mobility: 2"))
    val valuesN = mutableListOf<sector>(sector("Sector T", "Normal: 50", "", "", ""), sector("Sector D", "Normal: 20", "", "", ""), sector("Sector G", "Normal: 10", "", "", ""))
    val valuesM = mutableListOf<sector>(sector("Sector T", "Normal: 50", "", "Motorcycle: 10", ""), sector("Sector D", "Normal: 20", "", "Motorcycle: 5", ""), sector("Sector G", "Normal: 10", "", "Motorcycle: 1", ""))
    val valuesE = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "", ""), sector("Sector D", "Normal: 20", "Eletric: 1", "", ""), sector("Sector G", "Normal: 10", "Eletric: 0", "", ""))
    val valuesR = mutableListOf<sector>(sector("Sector T", "Normal: 50", "Eletric: 3", "", "R.Mobility: 1"), sector("Sector D", "Normal: 20", "Eletric: 1", "", "R.Mobility: 0"), sector("Sector G", "Normal: 10", "Eletric: 0", "", "R.Mobility: 2"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //---------------------------- Buttons -------------------------------------

        //Report button
        val report = findViewById<ImageButton>(R.id.dashboard_report)

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

        //--------------------------- Adapter ------------------------------
        var adapter = MySimpleArrayAdapterObjects(this, R.layout.layout_sector_dash, values)
        listView.adapter = adapter


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
            var adapter = MySimpleArrayAdapterObjects(this,
                R.layout.layout_sector_dash, valuesN)
            listView.adapter = adapter
        }

        //Show motocycle places on dashboard
        motoBtn.setOnClickListener{
            var adapter = MySimpleArrayAdapterObjects(this,
                R.layout.layout_sector_dash, valuesM)
            listView.adapter = adapter
        }

        //Show eletric places on dashboard
        eletricBtn.setOnClickListener{
            var adapter = MySimpleArrayAdapterObjects(this,
                R.layout.layout_sector_dash, valuesE)
            listView.adapter = adapter
        }

        //Show reduce mobility places on dashboard
        rmobBtn.setOnClickListener{
            var adapter = MySimpleArrayAdapterObjects(this,
                R.layout.layout_sector_dash, valuesR)
            listView.adapter = adapter
        }
    }

    override fun onBackPressed() {}
}