package com.example.isipark.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import com.example.isipark.R
import com.example.isipark.model.sector

class DashboardGestorActivity : AppCompatActivity() {

    val listView: ListView by lazy {
        findViewById<ListView>(R.id.dashboard_gestor_list_sectors)
    }

    //Values places
    val values = mutableListOf<sector>(
        sector("Sector T", "Normal: 50", "Eletric: 3", "Motorcycle: 10", "R.Mobility: 1"),
        sector("Sector D", "Normal: 20", "Eletric: 1", "Motorcycle: 5", "R.Mobility: 0"),
        sector("Sector G", "Normal: 10", "Eletric: 0", "Motorcycle: 1", "R.Mobility: 2")
    )
    val valuesN = mutableListOf<sector>(
        sector("Sector T", "Normal: 50", "", "", ""),
        sector("Sector D", "Normal: 20", "", "", ""),
        sector("Sector G", "Normal: 10", "", "", "")
    )
    val valuesM = mutableListOf<sector>(
        sector("Sector T", "Normal: 50", "", "Motorcycle: 10", ""),
        sector("Sector D", "Normal: 20", "", "Motorcycle: 5", ""),
        sector("Sector G", "Normal: 10", "", "Motorcycle: 1", "")
    )
    val valuesE = mutableListOf<sector>(
        sector("Sector T", "Normal: 50", "Eletric: 3", "", ""),
        sector("Sector D", "Normal: 20", "Eletric: 1", "", ""),
        sector("Sector G", "Normal: 10", "Eletric: 0", "", "")
    )
    val valuesR = mutableListOf<sector>(
        sector("Sector T", "Normal: 50", "Eletric: 3", "", "R.Mobility: 1"),
        sector("Sector D", "Normal: 20", "Eletric: 1", "", "R.Mobility: 0"),
        sector("Sector G", "Normal: 10", "Eletric: 0", "", "R.Mobility: 2")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_gestor)


        //Options buttons
        val noti = findViewById<ImageButton>(R.id.dashboard_g_notification)
        val codeBtn = findViewById<Button>(R.id.dashboard_gestor_code_btn)
        val moreOptions = findViewById<Button>(R.id.dashboard_gestor_more_btn)

        // Vehicle buttons
        val normalBtn = findViewById<ImageButton>(R.id.normal)
        val motoBtn = findViewById<ImageButton>(R.id.moto)
        val eletricBtn = findViewById<ImageButton>(R.id.eletric)
        val rmobBtn = findViewById<ImageButton>(R.id.rmob)
/*
        //Adapter
        var adapter = VehiclesArrayAdapter(this, R.layout.layout_sector_dash, values)
        listView.adapter = adapter

        // --------------------------------- Buttons information ----------------------------------------
        normalBtn.setOnClickListener {
            var adapter = VehiclesArrayAdapter(this, R.layout.layout_sector_dash, valuesN)
            listView.adapter = adapter
        }
        motoBtn.setOnClickListener {
            var adapter = VehiclesArrayAdapter(this, R.layout.layout_sector_dash, valuesM)
            listView.adapter = adapter
        }
        eletricBtn.setOnClickListener {
            var adapter = VehiclesArrayAdapter(this, R.layout.layout_sector_dash, valuesE)
            listView.adapter = adapter
        }
        rmobBtn.setOnClickListener {
            var adapter = VehiclesArrayAdapter(this, R.layout.layout_sector_dash, valuesR)
            listView.adapter = adapter
        }
*/

        // ------------------------------ Other Buttons ----------------------------------
        // Show code page
        codeBtn.setOnClickListener {
            val intent = Intent(this@DashboardGestorActivity, CodeGestorActivity::class.java)
            startActivity(intent)
        }

        // Show more options page
        moreOptions.setOnClickListener {
            val intent = Intent(this@DashboardGestorActivity, MoreOptionsActivity::class.java)
            startActivity(intent)
        }

        //Show notificationadmin page
        noti.setOnClickListener {
            val intent = Intent(this@DashboardGestorActivity, NotificationAdminActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {}


}